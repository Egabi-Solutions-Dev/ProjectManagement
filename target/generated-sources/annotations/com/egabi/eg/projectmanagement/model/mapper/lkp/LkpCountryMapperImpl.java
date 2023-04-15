package com.egabi.eg.projectmanagement.model.mapper.lkp;

import com.egabi.eg.projectmanagement.model.entities.lkp.LkpCountry;
import com.egabi.eg.projectmanagement.model.mapper.dto.LkpCountryDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-05T07:53:53+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class LkpCountryMapperImpl implements LkpCountryMapper {

    @Override
    public LkpCountry lkpCountryDtoToLkpCountry(LkpCountryDto lkpCountryDto) {
        if ( lkpCountryDto == null ) {
            return null;
        }

        LkpCountry lkpCountry = new LkpCountry();

        lkpCountry.setId( lkpCountryDto.getId() );
        lkpCountry.setNameEn( lkpCountryDto.getNameEn() );
        lkpCountry.setNameAr( lkpCountryDto.getNameAr() );
        lkpCountry.setPostalCode( lkpCountryDto.getPostalCode() );
        lkpCountry.setCountryCode( lkpCountryDto.getCountryCode() );

        return lkpCountry;
    }

    @Override
    public LkpCountryDto lkpCountryToLkpCountryDto(LkpCountry lkpCountry) {
        if ( lkpCountry == null ) {
            return null;
        }

        Long id = null;
        String nameEn = null;
        String nameAr = null;
        String postalCode = null;
        String countryCode = null;

        id = lkpCountry.getId();
        nameEn = lkpCountry.getNameEn();
        nameAr = lkpCountry.getNameAr();
        postalCode = lkpCountry.getPostalCode();
        countryCode = lkpCountry.getCountryCode();

        Boolean isDeleted = null;

        LkpCountryDto lkpCountryDto = new LkpCountryDto( id, isDeleted, nameEn, nameAr, postalCode, countryCode );

        return lkpCountryDto;
    }

    @Override
    public void updateLkpCountryFromLkpCountryDto(LkpCountryDto lkpCountryDto, LkpCountry lkpCountry) {
        if ( lkpCountryDto == null ) {
            return;
        }

        if ( lkpCountryDto.getId() != null ) {
            lkpCountry.setId( lkpCountryDto.getId() );
        }
        if ( lkpCountryDto.getNameEn() != null ) {
            lkpCountry.setNameEn( lkpCountryDto.getNameEn() );
        }
        if ( lkpCountryDto.getNameAr() != null ) {
            lkpCountry.setNameAr( lkpCountryDto.getNameAr() );
        }
        if ( lkpCountryDto.getPostalCode() != null ) {
            lkpCountry.setPostalCode( lkpCountryDto.getPostalCode() );
        }
        if ( lkpCountryDto.getCountryCode() != null ) {
            lkpCountry.setCountryCode( lkpCountryDto.getCountryCode() );
        }
    }
}
