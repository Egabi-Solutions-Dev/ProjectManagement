package com.egabi.eg.projectmanagement.model.mapper.lkp;

import com.egabi.eg.projectmanagement.model.entities.lkp.LkpAttachmentType;
import com.egabi.eg.projectmanagement.model.mapper.dto.LkpAttachmentTypeDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LkpAttachmentTypeMapper {
    LkpAttachmentType lkpAttachmentTypeDtoToLkpAttachmentType(LkpAttachmentTypeDto lkpAttachmentTypeDto);

    LkpAttachmentTypeDto lkpAttachmentTypeToLkpAttachmentTypeDto(LkpAttachmentType lkpAttachmentType);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLkpAttachmentTypeFromLkpAttachmentTypeDto(LkpAttachmentTypeDto lkpAttachmentTypeDto, @MappingTarget LkpAttachmentType lkpAttachmentType);
}
