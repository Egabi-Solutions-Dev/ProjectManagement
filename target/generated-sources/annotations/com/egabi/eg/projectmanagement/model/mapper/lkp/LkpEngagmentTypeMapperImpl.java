package com.egabi.eg.projectmanagement.model.mapper.lkp;

import com.egabi.eg.projectmanagement.model.entities.lkp.LkpEngagmentType;
import com.egabi.eg.projectmanagement.model.mapper.dto.LkpEngagmentTypeDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-05T07:53:54+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class LkpEngagmentTypeMapperImpl implements LkpEngagmentTypeMapper {

    @Override
    public LkpEngagmentType lkpEngagmentTypeDtoToLkpEngagmentType(LkpEngagmentTypeDto lkpEngagmentTypeDto) {
        if ( lkpEngagmentTypeDto == null ) {
            return null;
        }

        LkpEngagmentType lkpEngagmentType = new LkpEngagmentType();

        lkpEngagmentType.setId( lkpEngagmentTypeDto.getId() );
        lkpEngagmentType.setNameEn( lkpEngagmentTypeDto.getNameEn() );
        lkpEngagmentType.setNameAr( lkpEngagmentTypeDto.getNameAr() );

        return lkpEngagmentType;
    }

    @Override
    public LkpEngagmentTypeDto lkpEngagmentTypeToLkpEngagmentTypeDto(LkpEngagmentType lkpEngagmentType) {
        if ( lkpEngagmentType == null ) {
            return null;
        }

        Long id = null;
        String nameEn = null;
        String nameAr = null;

        id = lkpEngagmentType.getId();
        nameEn = lkpEngagmentType.getNameEn();
        nameAr = lkpEngagmentType.getNameAr();

        Boolean isDeleted = null;

        LkpEngagmentTypeDto lkpEngagmentTypeDto = new LkpEngagmentTypeDto( id, isDeleted, nameEn, nameAr );

        return lkpEngagmentTypeDto;
    }

    @Override
    public void updateLkpEngagmentTypeFromLkpEngagmentTypeDto(LkpEngagmentTypeDto lkpEngagmentTypeDto, LkpEngagmentType lkpEngagmentType) {
        if ( lkpEngagmentTypeDto == null ) {
            return;
        }

        if ( lkpEngagmentTypeDto.getId() != null ) {
            lkpEngagmentType.setId( lkpEngagmentTypeDto.getId() );
        }
        if ( lkpEngagmentTypeDto.getNameEn() != null ) {
            lkpEngagmentType.setNameEn( lkpEngagmentTypeDto.getNameEn() );
        }
        if ( lkpEngagmentTypeDto.getNameAr() != null ) {
            lkpEngagmentType.setNameAr( lkpEngagmentTypeDto.getNameAr() );
        }
    }
}
