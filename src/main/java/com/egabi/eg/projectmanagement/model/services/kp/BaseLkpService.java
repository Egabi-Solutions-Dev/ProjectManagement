package com.egabi.eg.projectmanagement.model.services.kp;

import com.egabi.eg.projectmanagement.model.entities.lkp.BaseLkpEntity;
import com.egabi.eg.projectmanagement.model.repositories.lkp.BaseLkpRepository;
import com.egabi.eg.projectmanagement.utils.JavaxValidator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;



public class BaseLkpService<T extends BaseLkpEntity , ID> {
    @PersistenceContext
    private EntityManager entityManager;

    private BaseLkpRepository<T,ID> repo;

    @Autowired
    private JavaxValidator<T> validator;
    Class<T> type;

    public BaseLkpService(Class<T> type){
        this.type = type;
    }

    @PostConstruct
    public void init(){

        repo = new BaseLkpRepository<T,ID>(type, this.entityManager);
    }


    public List<T> findAll(){
        List<T> all = repo.findAll();
        return all;
    }

    public List<T> findAllActive(){
        List<T> all = repo.findAllActive();
        return all;
    }


    public Optional<T> findById( ID id){
        return repo.findById(id);
    }


    @Transactional
    public T save(T t){
        validator.validate(t);
        T all = repo.save(t);
        return all;
    }
    @Transactional
    public T updateLkp(T t){
//        BaseLkpEntity t1 = t;
        ID id = (ID) t.getId();


        T existingEntity =repo.findById(id).orElse(null);
        if (existingEntity!=null){
            validator.validate(t);
            return repo.save(t);
        }
        return null;
    }

    @Transactional
    public boolean softDeleteLkpById(ID id) {
        Optional<T> byId = repo.findById(id);
        T t = byId.get();
        t.setDeleted(true);
        validator.validate(t);
        repo.save(t);
        return true;//this.updateLkp()
    }

    @Transactional
    public boolean hardDeleteLkpById(ID id) {
        repo.deleteById(id);
        return true;
    }
}

