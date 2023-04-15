package com.egabi.eg.projectmanagement.model.mapper.lkp;

import com.egabi.eg.projectmanagement.model.entities.lkp.LkpStatus;
import com.egabi.eg.projectmanagement.model.mapper.dto.LkpStatusDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LkpStatusMapper {
    LkpStatus lkpStatusDtoToLkpStatus(LkpStatusDto lkpStatusDto);

    LkpStatusDto lkpStatusToLkpStatusDto(LkpStatus lkpStatus);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLkpStatusFromLkpStatusDto(LkpStatusDto lkpStatusDto, @MappingTarget LkpStatus lkpStatus);
}
