package com.egabi.eg.projectmanagement.model.repositories.lkp;

import com.egabi.eg.projectmanagement.model.entities.lkp.BaseLkpEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.convert.QueryByExamplePredicateBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.EscapeCharacter;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@NoRepositoryBean
public class BaseLkpRepository<T extends BaseLkpEntity,ID> extends SimpleJpaRepository<T,ID> {

    public BaseLkpRepository(Class domainClass, EntityManager em) {
        super(domainClass, em);
    }


    public List<T> findAllActive(){
        Specs spec = new Specs(new SearchCriteria("isDeleted", ":", false));

        List<T> results = super.findAll((Specification<T>) spec);

        if(results!=null){
            System.out.println("results.size()>>>>"+results.size());
        }

        return results;
    }

}