package com.egabi.eg.projectmanagement.controllers.transaction;

import com.egabi.eg.projectmanagement.model.dto.transactions.ProjectDto;
import com.egabi.eg.projectmanagement.model.dto.transactions.ProjectListItem;
import com.egabi.eg.projectmanagement.model.dto.transactions.ProjectSearchReqDto;
import com.egabi.eg.projectmanagement.model.entities.lkp.BaseLkpEntity;
import com.egabi.eg.projectmanagement.model.services.kp.BaseLkpService;
import com.egabi.eg.projectmanagement.model.services.transactions.ProjectServiceImpl;
import com.egabi.eg.projectmanagement.response.ApiBaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/PM/api/project/")
public class ProjectController {

    @Autowired
    private ProjectServiceImpl projectService;


//
//    @GetMapping("/findAllActive")
//    public ApiBaseModel<List<T>> findAllBy(){
//
//        ApiBaseModel<List<T>> res=null;
//
//        List<T> list = baseLkpService.findAllActive();
//
//        res = new ApiBaseModel(true,list);
//
//        return res;
//
//    }
//
    @PostMapping("/addNewLkpData")
    public ApiBaseModel<Long> createProject(@RequestBody ProjectDto projectDto) {
        ApiBaseModel<Long> res = projectService.createProject(projectDto);
        return res;
    }

    @PostMapping("/updateProject")
    public ApiBaseModel<Long> updateProject(@RequestBody ProjectDto projectDto){
        ApiBaseModel<Long> res=null;

        ApiBaseModel<Long> longApiBaseModel = projectService.updateProject(projectDto);

        return res;

    }

    @PostMapping("/deleteProject")
    public ApiBaseModel deleteProject(@RequestParam Long id){
        ApiBaseModel res=null;

        res = projectService.deleteProject(id);
        return res;
    }

    @PostMapping("/findAllData")
    public ApiBaseModel<List<ProjectListItem>> findAll(@RequestBody ProjectSearchReqDto projectSearchReqDto,
                                                       @RequestParam(required = false) Integer currentPage,@RequestParam(required = false) Integer pageSize){

        ApiBaseModel<List<ProjectListItem>> res=projectService.searchInProjects(projectSearchReqDto,currentPage,pageSize);

        return res;
    }


}
