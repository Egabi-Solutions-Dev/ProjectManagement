package com.egabi.eg.projectmanagement.model.mapper.lkp;

import com.egabi.eg.projectmanagement.model.entities.lkp.LkpSector;
import com.egabi.eg.projectmanagement.model.mapper.dto.LkpSectorDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LkpSectorMapper {
    LkpSector lkpSectorDtoToLkpSector(LkpSectorDto lkpSectorDto);

    LkpSectorDto lkpSectorToLkpSectorDto(LkpSector lkpSector);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLkpSectorFromLkpSectorDto(LkpSectorDto lkpSectorDto, @MappingTarget LkpSector lkpSector);
}
