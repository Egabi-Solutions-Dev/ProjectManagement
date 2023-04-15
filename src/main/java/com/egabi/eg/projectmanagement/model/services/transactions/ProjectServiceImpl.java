package com.egabi.eg.projectmanagement.model.services.transactions;

import com.egabi.eg.projectmanagement.model.dto.transactions.ProjectDto;
import com.egabi.eg.projectmanagement.model.dto.transactions.ProjectListItem;
import com.egabi.eg.projectmanagement.model.dto.transactions.ProjectSearchReqDto;
import com.egabi.eg.projectmanagement.model.entities.transactions.Project;
import com.egabi.eg.projectmanagement.model.mapper.ProjectMapper;
import com.egabi.eg.projectmanagement.model.repositories.transactions.ProjectRepository;
import com.egabi.eg.projectmanagement.response.ApiBaseModel;
import com.egabi.eg.projectmanagement.utils.CustomPagination;
import com.egabi.eg.projectmanagement.utils.JavaxValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProjectServiceImpl{

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    JavaxValidator<Project> projectJavaxValidator;

    @Autowired
    ProjectMapper projectMapper;


    public ApiBaseModel<Long> createProject(ProjectDto projectDto){
        ApiBaseModel<Long> res = null;
        Project project = projectMapper.projectDtoToProject(projectDto);

        projectJavaxValidator.validate(project);
        project = projectRepository.save(project);

        res = new ApiBaseModel<>(true,project.getId());
        return res;
    }


    public ApiBaseModel<Boolean> deleteProject(Long projectId){
        ApiBaseModel<Boolean> res = null;

        if(projectId==null ){
            JavaxValidator.throwInvalidInputs();
        }
        projectRepository.deleteById(projectId);
        res = new ApiBaseModel<Boolean>(true,true);
        return res;
    }


    public ApiBaseModel<Long> updateProject(ProjectDto projectDto){
        ApiBaseModel<Long> res = null;
        Optional<Project> projectOpt = projectRepository.findById(projectDto.getId());

        Project persistedProject = projectOpt.orElseThrow(projectJavaxValidator.notFound(Project.class));

        Project project = projectMapper.projectDtoToProject(projectDto);

        projectJavaxValidator.validate(project);
        projectRepository.save(project);
        //projectOpt.ifPresent(projectJavaxValidator.alreadyExist());
        res = new ApiBaseModel<Long>(true,projectDto.getId());
        return res;
    }


    public ApiBaseModel<List<ProjectListItem>> searchInProjects(ProjectSearchReqDto projectSearchReqDto,Integer currentPage,Integer pageSize){
        ApiBaseModel<List<ProjectListItem>> apiBaseModel = null;
        CustomPagination pagination = new CustomPagination(currentPage,pageSize);

        Page<ProjectListItem> projectPage = projectRepository.searchInProjects(projectSearchReqDto.getProjectNameAr()
                                                                               ,projectSearchReqDto.getProjectNameEn()
                                                                               ,projectSearchReqDto.getProjectStatusId()
                                                                               ,projectSearchReqDto.getPmUser()
                                                                               ,projectSearchReqDto.getProjectAwardedDateFrom()
                                                                               ,projectSearchReqDto.getProjectAwardedDateTo()
                                                                               ,projectSearchReqDto.getRegionId()
                                                                               , projectSearchReqDto.getCountryId()
                                                                               , projectSearchReqDto.getSectorId()
                                                                               ,pagination.getPageable());

        apiBaseModel = new ApiBaseModel<>(Boolean.TRUE,projectPage.toList());
        apiBaseModel.setPageInfo(pagination.getPageInfoApiModel(projectPage));
        return apiBaseModel;
    }





}
