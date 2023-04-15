package com.egabi.eg.projectmanagement.model.mapper;

import com.egabi.eg.projectmanagement.model.dto.transactions.ProjectDto;
import com.egabi.eg.projectmanagement.model.entities.transactions.Project;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-05T07:53:53+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public Project projectDtoToProject(ProjectDto projectDto) {
        if ( projectDto == null ) {
            return null;
        }

        Project project = new Project();

        project.setId( projectDto.getId() );
        project.setProjectCode( projectDto.getProjectCode() );
        project.setProjectNameEn( projectDto.getProjectNameEn() );
        project.setProjectNameAr( projectDto.getProjectNameAr() );
        project.setProjectDescription( projectDto.getProjectDescription() );
        project.setProjectStartDate( projectDto.getProjectStartDate() );
        project.setProjectEndDate( projectDto.getProjectEndDate() );
        project.setProposalSubmmissionDate( projectDto.getProposalSubmmissionDate() );
        project.setProjectAwardedDate( projectDto.getProjectAwardedDate() );
        project.setSalesUser( projectDto.getSalesUser() );
        project.setPmUser( projectDto.getPmUser() );
        project.setDepartmentId( projectDto.getDepartmentId() );

        return project;
    }

    @Override
    public ProjectDto projectToProjectDto(Project project) {
        if ( project == null ) {
            return null;
        }

        Long id = null;
        String projectCode = null;
        String projectNameEn = null;
        String projectNameAr = null;

        id = project.getId();
        projectCode = project.getProjectCode();
        projectNameEn = project.getProjectNameEn();
        projectNameAr = project.getProjectNameAr();

        ProjectDto projectDto = new ProjectDto( id, projectCode, projectNameEn, projectNameAr );

        projectDto.setProjectDescription( project.getProjectDescription() );
        projectDto.setProjectStartDate( project.getProjectStartDate() );
        projectDto.setProjectEndDate( project.getProjectEndDate() );
        projectDto.setProposalSubmmissionDate( project.getProposalSubmmissionDate() );
        projectDto.setProjectAwardedDate( project.getProjectAwardedDate() );
        projectDto.setSalesUser( project.getSalesUser() );
        projectDto.setPmUser( project.getPmUser() );
        projectDto.setDepartmentId( project.getDepartmentId() );

        return projectDto;
    }

    @Override
    public void updateProjectFromProjectDto(ProjectDto projectDto, Project project) {
        if ( projectDto == null ) {
            return;
        }

        if ( projectDto.getId() != null ) {
            project.setId( projectDto.getId() );
        }
        if ( projectDto.getProjectCode() != null ) {
            project.setProjectCode( projectDto.getProjectCode() );
        }
        if ( projectDto.getProjectNameEn() != null ) {
            project.setProjectNameEn( projectDto.getProjectNameEn() );
        }
        if ( projectDto.getProjectNameAr() != null ) {
            project.setProjectNameAr( projectDto.getProjectNameAr() );
        }
        if ( projectDto.getProjectDescription() != null ) {
            project.setProjectDescription( projectDto.getProjectDescription() );
        }
        if ( projectDto.getProjectStartDate() != null ) {
            project.setProjectStartDate( projectDto.getProjectStartDate() );
        }
        if ( projectDto.getProjectEndDate() != null ) {
            project.setProjectEndDate( projectDto.getProjectEndDate() );
        }
        if ( projectDto.getProposalSubmmissionDate() != null ) {
            project.setProposalSubmmissionDate( projectDto.getProposalSubmmissionDate() );
        }
        if ( projectDto.getProjectAwardedDate() != null ) {
            project.setProjectAwardedDate( projectDto.getProjectAwardedDate() );
        }
        if ( projectDto.getSalesUser() != null ) {
            project.setSalesUser( projectDto.getSalesUser() );
        }
        if ( projectDto.getPmUser() != null ) {
            project.setPmUser( projectDto.getPmUser() );
        }
        if ( projectDto.getDepartmentId() != null ) {
            project.setDepartmentId( projectDto.getDepartmentId() );
        }
    }
}
