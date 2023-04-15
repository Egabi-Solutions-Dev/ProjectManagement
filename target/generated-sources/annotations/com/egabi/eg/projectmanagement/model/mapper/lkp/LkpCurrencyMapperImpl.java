package com.egabi.eg.projectmanagement.model.mapper.lkp;

import com.egabi.eg.projectmanagement.model.entities.lkp.LkpCurrency;
import com.egabi.eg.projectmanagement.model.mapper.dto.LkpCurrencyDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-05T07:53:53+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class LkpCurrencyMapperImpl implements LkpCurrencyMapper {

    @Override
    public LkpCurrency lkpCurrencyDtoToLkpCurrency(LkpCurrencyDto lkpCurrencyDto) {
        if ( lkpCurrencyDto == null ) {
            return null;
        }

        LkpCurrency lkpCurrency = new LkpCurrency();

        lkpCurrency.setId( lkpCurrencyDto.getId() );
        lkpCurrency.setCurrencyCode( lkpCurrencyDto.getCurrencyCode() );
        lkpCurrency.setNameEn( lkpCurrencyDto.getNameEn() );
        lkpCurrency.setNameAr( lkpCurrencyDto.getNameAr() );

        return lkpCurrency;
    }

    @Override
    public LkpCurrencyDto lkpCurrencyToLkpCurrencyDto(LkpCurrency lkpCurrency) {
        if ( lkpCurrency == null ) {
            return null;
        }

        Long id = null;
        String currencyCode = null;
        String nameEn = null;
        String nameAr = null;

        id = lkpCurrency.getId();
        currencyCode = lkpCurrency.getCurrencyCode();
        nameEn = lkpCurrency.getNameEn();
        nameAr = lkpCurrency.getNameAr();

        Boolean isDeleted = null;

        LkpCurrencyDto lkpCurrencyDto = new LkpCurrencyDto( id, isDeleted, currencyCode, nameEn, nameAr );

        return lkpCurrencyDto;
    }

    @Override
    public void updateLkpCurrencyFromLkpCurrencyDto(LkpCurrencyDto lkpCurrencyDto, LkpCurrency lkpCurrency) {
        if ( lkpCurrencyDto == null ) {
            return;
        }

        if ( lkpCurrencyDto.getId() != null ) {
            lkpCurrency.setId( lkpCurrencyDto.getId() );
        }
        if ( lkpCurrencyDto.getCurrencyCode() != null ) {
            lkpCurrency.setCurrencyCode( lkpCurrencyDto.getCurrencyCode() );
        }
        if ( lkpCurrencyDto.getNameEn() != null ) {
            lkpCurrency.setNameEn( lkpCurrencyDto.getNameEn() );
        }
        if ( lkpCurrencyDto.getNameAr() != null ) {
            lkpCurrency.setNameAr( lkpCurrencyDto.getNameAr() );
        }
    }
}
