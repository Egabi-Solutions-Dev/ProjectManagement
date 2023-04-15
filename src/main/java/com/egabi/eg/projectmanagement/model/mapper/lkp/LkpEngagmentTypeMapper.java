package com.egabi.eg.projectmanagement.model.mapper.lkp;

import com.egabi.eg.projectmanagement.model.entities.lkp.LkpEngagmentType;
import com.egabi.eg.projectmanagement.model.mapper.dto.LkpEngagmentTypeDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LkpEngagmentTypeMapper {
    LkpEngagmentType lkpEngagmentTypeDtoToLkpEngagmentType(LkpEngagmentTypeDto lkpEngagmentTypeDto);

    LkpEngagmentTypeDto lkpEngagmentTypeToLkpEngagmentTypeDto(LkpEngagmentType lkpEngagmentType);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLkpEngagmentTypeFromLkpEngagmentTypeDto(LkpEngagmentTypeDto lkpEngagmentTypeDto, @MappingTarget LkpEngagmentType lkpEngagmentType);
}
