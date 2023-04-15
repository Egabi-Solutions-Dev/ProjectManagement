package com.egabi.eg.projectmanagement.model.mapper;

import com.egabi.eg.projectmanagement.model.entities.transactions.Project;
import com.egabi.eg.projectmanagement.model.dto.transactions.ProjectDto;

@org.mapstruct.Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProjectMapper {
    Project projectDtoToProject(ProjectDto projectDto);

    ProjectDto projectToProjectDto(Project project);

    @org.mapstruct.BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    void updateProjectFromProjectDto(ProjectDto projectDto, @org.mapstruct.MappingTarget Project project);
}
