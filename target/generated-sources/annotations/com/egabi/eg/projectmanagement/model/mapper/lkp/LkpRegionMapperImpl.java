package com.egabi.eg.projectmanagement.model.mapper.lkp;

import com.egabi.eg.projectmanagement.model.entities.lkp.LkpRegion;
import com.egabi.eg.projectmanagement.model.mapper.dto.LkpRegionDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-05T07:53:54+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class LkpRegionMapperImpl implements LkpRegionMapper {

    @Override
    public LkpRegion lkpRegionDtoToLkpRegion(LkpRegionDto lkpRegionDto) {
        if ( lkpRegionDto == null ) {
            return null;
        }

        LkpRegion lkpRegion = new LkpRegion();

        lkpRegion.setId( lkpRegionDto.getId() );
        lkpRegion.setRegionCode( lkpRegionDto.getRegionCode() );
        lkpRegion.setNameEn( lkpRegionDto.getNameEn() );
        lkpRegion.setNameAr( lkpRegionDto.getNameAr() );

        return lkpRegion;
    }

    @Override
    public LkpRegionDto lkpRegionToLkpRegionDto(LkpRegion lkpRegion) {
        if ( lkpRegion == null ) {
            return null;
        }

        Long id = null;
        String regionCode = null;
        String nameEn = null;
        String nameAr = null;

        id = lkpRegion.getId();
        regionCode = lkpRegion.getRegionCode();
        nameEn = lkpRegion.getNameEn();
        nameAr = lkpRegion.getNameAr();

        Boolean isDeleted = null;

        LkpRegionDto lkpRegionDto = new LkpRegionDto( id, isDeleted, regionCode, nameEn, nameAr );

        return lkpRegionDto;
    }

    @Override
    public void updateLkpRegionFromLkpRegionDto(LkpRegionDto lkpRegionDto, LkpRegion lkpRegion) {
        if ( lkpRegionDto == null ) {
            return;
        }

        if ( lkpRegionDto.getId() != null ) {
            lkpRegion.setId( lkpRegionDto.getId() );
        }
        if ( lkpRegionDto.getRegionCode() != null ) {
            lkpRegion.setRegionCode( lkpRegionDto.getRegionCode() );
        }
        if ( lkpRegionDto.getNameEn() != null ) {
            lkpRegion.setNameEn( lkpRegionDto.getNameEn() );
        }
        if ( lkpRegionDto.getNameAr() != null ) {
            lkpRegion.setNameAr( lkpRegionDto.getNameAr() );
        }
    }
}
