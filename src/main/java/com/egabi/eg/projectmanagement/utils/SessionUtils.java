package com.egabi.eg.projectmanagement.utils;


import com.egabi.eg.projectmanagement.constant.ErrorMessage;
import com.egabi.eg.projectmanagement.exception.CDCUnauthorizedException;
import com.egabi.eg.projectmanagement.security.UserDetailsImpl;
//import com.egabi.eg.zatcaservices.constant.ErrorMessage;
//import com.egabi.eg.zatcaservices.exception.CDCUnauthorizedException;
//import com.egabi.eg.zatcaservices.security.UserDetailsImpl;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *  
 * @since 5/31/2021 - 3:52 PM
 */
public class SessionUtils {

    public static UserDetailsImpl getCurrentUser() throws CDCUnauthorizedException {

        System.out.println("SecurityContextHolder.getContext().getAuthentication().getPrincipal()"+SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal !=null && principal instanceof UserDetailsImpl){
            return (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }else{
            throw new CDCUnauthorizedException(ErrorMessage.INVALID_TOKEN.name());
        }
    }
}