package com.egabi.eg.projectmanagement.model.mapper.lkp;

import com.egabi.eg.projectmanagement.model.entities.lkp.LkpRegion;
import com.egabi.eg.projectmanagement.model.mapper.dto.LkpRegionDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LkpRegionMapper {
    LkpRegion lkpRegionDtoToLkpRegion(LkpRegionDto lkpRegionDto);

    LkpRegionDto lkpRegionToLkpRegionDto(LkpRegion lkpRegion);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLkpRegionFromLkpRegionDto(LkpRegionDto lkpRegionDto, @MappingTarget LkpRegion lkpRegion);
}
