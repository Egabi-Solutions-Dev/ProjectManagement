package com.egabi.eg.projectmanagement.utils;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Component
public class JavaxValidator<T> {

    @Autowired
    private Validator validator;


    public boolean validate(T object){
        Set<ConstraintViolation<T>> violations = validator.validate(object);
        boolean isFirstViolation=true;
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<T> constraintViolation : violations) {

                String rootBeanClass = constraintViolation.getRootBeanClass().getName();
                String propertyPath = constraintViolation.getPropertyPath().toString();
                String validationName  = constraintViolation.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName();
                String resource = rootBeanClass+"."+propertyPath+"."+validationName;
                System.out.println();

                if(isFirstViolation){
                    sb.append(resource);
                    isFirstViolation=false;
                }else{
                    sb.append(","+resource);
                }

            }
            throw new ConstraintViolationException(sb.toString(), violations);
        }
        return true;
    }

    public Supplier<ConstraintViolationException> notFound(Class clazz){

        Supplier<ConstraintViolationException> xc = () -> {

            ConstraintViolationException xx = new ConstraintViolationException(clazz.getCanonicalName()+".NotFound",null);
            return xx;

        };
        return xc;
    }

    public Consumer<T> alreadyExist(){

        Consumer<T> xc = t1 -> {
            ConstraintViolationException xx = new ConstraintViolationException(t1.getClass().getCanonicalName()+".AlreadyExist",null);
            throw xx;
        };
        return xc;
    }





    public static void throwInvalidInputs(){
        throw new ConstraintViolationException(
                "ErrorMessage.InvalidInputs.name()"
                ,null);
    }

}
