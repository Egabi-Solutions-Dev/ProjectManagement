package com.egabi.eg.projectmanagement.model.services.kp;

import com.egabi.eg.projectmanagement.model.entities.lkp.BaseEntity;
import com.egabi.eg.projectmanagement.model.repositories.lkp.*;

import java.util.List;

//@Service
public class LkpTransactionalService {
//    @Autowired
    BaseRepository <BaseEntity> lkpRepository;

    public Long addLkpData(BaseEntity s){
        return lkpRepository.save(s).getId();
    }
    public boolean softDeleteLkpById(Long id){
        BaseEntity existingEntity =lkpRepository.findById(id).orElse(null);
        if (existingEntity!=null){
//            existingEntity.
        }
        return false;
    }

    public boolean hardDeleteLkpById(Long id){
        BaseEntity existingEntity =lkpRepository.findById(id).orElse(null);
        if (existingEntity!=null){
            lkpRepository.delete(existingEntity);
        }
        return false;
    }

    public BaseEntity updateLkp(BaseEntity entity){
        BaseEntity existingEntity =lkpRepository.findById(entity.getId()).orElse(null);
        if (existingEntity!=null){
            return lkpRepository.save(entity);
        }
        return null;
    }

    public List<BaseEntity> returnAllEntities(){
        List<BaseEntity> entities= (List<BaseEntity>) lkpRepository.findAll();
        return entities;
    }
}
