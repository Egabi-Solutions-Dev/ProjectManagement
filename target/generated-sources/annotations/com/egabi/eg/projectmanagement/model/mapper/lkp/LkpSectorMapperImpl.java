package com.egabi.eg.projectmanagement.model.mapper.lkp;

import com.egabi.eg.projectmanagement.model.entities.lkp.LkpSector;
import com.egabi.eg.projectmanagement.model.mapper.dto.LkpSectorDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-05T07:53:53+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class LkpSectorMapperImpl implements LkpSectorMapper {

    @Override
    public LkpSector lkpSectorDtoToLkpSector(LkpSectorDto lkpSectorDto) {
        if ( lkpSectorDto == null ) {
            return null;
        }

        LkpSector lkpSector = new LkpSector();

        lkpSector.setId( lkpSectorDto.getId() );
        lkpSector.setNameEn( lkpSectorDto.getNameEn() );
        lkpSector.setNameAr( lkpSectorDto.getNameAr() );
        lkpSector.setSectoreCode( lkpSectorDto.getSectoreCode() );

        return lkpSector;
    }

    @Override
    public LkpSectorDto lkpSectorToLkpSectorDto(LkpSector lkpSector) {
        if ( lkpSector == null ) {
            return null;
        }

        Long id = null;
        String nameEn = null;
        String nameAr = null;
        String sectoreCode = null;

        id = lkpSector.getId();
        nameEn = lkpSector.getNameEn();
        nameAr = lkpSector.getNameAr();
        sectoreCode = lkpSector.getSectoreCode();

        Boolean isDeleted = null;

        LkpSectorDto lkpSectorDto = new LkpSectorDto( id, isDeleted, nameEn, nameAr, sectoreCode );

        return lkpSectorDto;
    }

    @Override
    public void updateLkpSectorFromLkpSectorDto(LkpSectorDto lkpSectorDto, LkpSector lkpSector) {
        if ( lkpSectorDto == null ) {
            return;
        }

        if ( lkpSectorDto.getId() != null ) {
            lkpSector.setId( lkpSectorDto.getId() );
        }
        if ( lkpSectorDto.getNameEn() != null ) {
            lkpSector.setNameEn( lkpSectorDto.getNameEn() );
        }
        if ( lkpSectorDto.getNameAr() != null ) {
            lkpSector.setNameAr( lkpSectorDto.getNameAr() );
        }
        if ( lkpSectorDto.getSectoreCode() != null ) {
            lkpSector.setSectoreCode( lkpSectorDto.getSectoreCode() );
        }
    }
}
