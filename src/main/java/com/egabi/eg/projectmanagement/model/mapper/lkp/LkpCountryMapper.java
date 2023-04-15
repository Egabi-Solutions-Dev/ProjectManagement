package com.egabi.eg.projectmanagement.model.mapper.lkp;

import com.egabi.eg.projectmanagement.model.entities.lkp.LkpCountry;
import com.egabi.eg.projectmanagement.model.mapper.dto.LkpCountryDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LkpCountryMapper {
    LkpCountry lkpCountryDtoToLkpCountry(LkpCountryDto lkpCountryDto);

    LkpCountryDto lkpCountryToLkpCountryDto(LkpCountry lkpCountry);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLkpCountryFromLkpCountryDto(LkpCountryDto lkpCountryDto, @MappingTarget LkpCountry lkpCountry);
}
