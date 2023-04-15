package com.egabi.eg.projectmanagement.model.mapper.lkp;

import com.egabi.eg.projectmanagement.model.entities.lkp.LkpCurrency;
import com.egabi.eg.projectmanagement.model.mapper.dto.LkpCurrencyDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface LkpCurrencyMapper {
    LkpCurrency lkpCurrencyDtoToLkpCurrency(LkpCurrencyDto lkpCurrencyDto);

    LkpCurrencyDto lkpCurrencyToLkpCurrencyDto(LkpCurrency lkpCurrency);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateLkpCurrencyFromLkpCurrencyDto(LkpCurrencyDto lkpCurrencyDto, @MappingTarget LkpCurrency lkpCurrency);
}
