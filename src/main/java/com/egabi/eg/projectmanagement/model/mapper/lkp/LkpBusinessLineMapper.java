package com.egabi.eg.projectmanagement.model.mapper.lkp;

import com.egabi.eg.projectmanagement.model.entities.lkp.LkpBusinessLine;
import com.egabi.eg.projectmanagement.model.mapper.dto.LkpBusinessLineDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LkpBusinessLineMapper {
    LkpBusinessLine lkpBusinessLineDtoTolkpBusinessLine(LkpBusinessLineDto lkpBusinessLineDto);

    LkpBusinessLineDto lkpBusinessLineToLkpBusinessLineDto(LkpBusinessLine lkpBusinessLine);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatelkpBusinessLineFromLkpBusinessLineDto(LkpBusinessLineDto lkpBusinessLineDto, @MappingTarget LkpBusinessLine lkpBusinessLine);
}
