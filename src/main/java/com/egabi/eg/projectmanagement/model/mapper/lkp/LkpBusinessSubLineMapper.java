package com.egabi.eg.projectmanagement.model.mapper.lkp;

import com.egabi.eg.projectmanagement.model.entities.lkp.LkpBusinessSubLine;
import com.egabi.eg.projectmanagement.model.mapper.dto.LkpBusinessSubLineDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LkpBusinessSubLineMapper {
    LkpBusinessSubLine lkpBusinessSubLineDtoToLkpBusinessSubLine(LkpBusinessSubLineDto lkpBusinessSubLineDto);

    LkpBusinessSubLineDto lkpBusinessSubLineToLkpBusinessSubLineDto(LkpBusinessSubLine lkpBusinessSubLine);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLkpBusinessSubLineFromLkpBusinessSubLineDto(LkpBusinessSubLineDto lkpBusinessSubLineDto, @MappingTarget LkpBusinessSubLine lkpBusinessSubLine);
}
