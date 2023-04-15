package com.egabi.eg.projectmanagement.controllers.lkp;

import com.egabi.eg.projectmanagement.model.entities.lkp.BaseLkpEntity;
import com.egabi.eg.projectmanagement.model.services.kp.BaseLkpService;
import com.egabi.eg.projectmanagement.response.ApiBaseModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LkpController<T extends BaseLkpEntity, ID> {

    private BaseLkpService baseLkpService;

    public LkpController(BaseLkpService baseLkpService) {
        this.baseLkpService = baseLkpService;
    }


    @GetMapping("/findAllActive")
    public ApiBaseModel<List<T>> findAllBy(){

        ApiBaseModel<List<T>> res=null;

        List<T> list = baseLkpService.findAllActive();

        res = new ApiBaseModel(true,list);

        return res;

    }

    @PostMapping("/addNewLkpData")
    public ApiBaseModel<T> addNewLkpData(@RequestBody T entity) {
        ApiBaseModel<T> res = null;

        T saved = (T) baseLkpService.save(entity);

        res = new ApiBaseModel<T>(true,saved);

        return res;
    }

    @PostMapping("/updateLkpData")
    public ApiBaseModel<T> updateLkpData(@RequestBody T entity){
        ApiBaseModel<T> res=null;

        T updated = (T) baseLkpService.updateLkp(entity);

        res = new ApiBaseModel<T>(true,updated);

        return res;

    }

    @PostMapping("/softDeleteLkp")
    public ApiBaseModel softDeleteLkpByID(@RequestParam ID id){

        ApiBaseModel res=null;

        Boolean del = baseLkpService.softDeleteLkpById(id);
        res = new ApiBaseModel(del,null);

        return res;
    }
    @PostMapping("/hardDeleteLkpByID")
    public ApiBaseModel hardDeleteLkpByID(@RequestParam ID id){


        ApiBaseModel res=null;

        Boolean del = baseLkpService.hardDeleteLkpById(id);
        res = new ApiBaseModel(del,null);

        return res;

    }

    @GetMapping("/findAllData")
    public ApiBaseModel<List<T>> findAll(){

        ApiBaseModel<List<T>> res=null;

        List<T> list = baseLkpService.findAll();

        res = new ApiBaseModel(true,list);

        return res;

    }


}
