package com.egabi.eg.projectmanagement.model.mapper.lkp;

import com.egabi.eg.projectmanagement.model.entities.lkp.LkpAttachmentType;
import com.egabi.eg.projectmanagement.model.mapper.dto.LkpAttachmentTypeDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-05T07:53:54+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class LkpAttachmentTypeMapperImpl implements LkpAttachmentTypeMapper {

    @Override
    public LkpAttachmentType lkpAttachmentTypeDtoToLkpAttachmentType(LkpAttachmentTypeDto lkpAttachmentTypeDto) {
        if ( lkpAttachmentTypeDto == null ) {
            return null;
        }

        LkpAttachmentType lkpAttachmentType = new LkpAttachmentType();

        lkpAttachmentType.setId( lkpAttachmentTypeDto.getId() );
        lkpAttachmentType.setNameAr( lkpAttachmentTypeDto.getNameAr() );
        lkpAttachmentType.setNameEn( lkpAttachmentTypeDto.getNameEn() );
        lkpAttachmentType.setEcmTypeName( lkpAttachmentTypeDto.getEcmTypeName() );

        return lkpAttachmentType;
    }

    @Override
    public LkpAttachmentTypeDto lkpAttachmentTypeToLkpAttachmentTypeDto(LkpAttachmentType lkpAttachmentType) {
        if ( lkpAttachmentType == null ) {
            return null;
        }

        Long id = null;
        String nameAr = null;
        String nameEn = null;
        String ecmTypeName = null;

        id = lkpAttachmentType.getId();
        nameAr = lkpAttachmentType.getNameAr();
        nameEn = lkpAttachmentType.getNameEn();
        ecmTypeName = lkpAttachmentType.getEcmTypeName();

        Boolean isDeleted = null;

        LkpAttachmentTypeDto lkpAttachmentTypeDto = new LkpAttachmentTypeDto( id, isDeleted, nameAr, nameEn, ecmTypeName );

        return lkpAttachmentTypeDto;
    }

    @Override
    public void updateLkpAttachmentTypeFromLkpAttachmentTypeDto(LkpAttachmentTypeDto lkpAttachmentTypeDto, LkpAttachmentType lkpAttachmentType) {
        if ( lkpAttachmentTypeDto == null ) {
            return;
        }

        if ( lkpAttachmentTypeDto.getId() != null ) {
            lkpAttachmentType.setId( lkpAttachmentTypeDto.getId() );
        }
        if ( lkpAttachmentTypeDto.getNameAr() != null ) {
            lkpAttachmentType.setNameAr( lkpAttachmentTypeDto.getNameAr() );
        }
        if ( lkpAttachmentTypeDto.getNameEn() != null ) {
            lkpAttachmentType.setNameEn( lkpAttachmentTypeDto.getNameEn() );
        }
        if ( lkpAttachmentTypeDto.getEcmTypeName() != null ) {
            lkpAttachmentType.setEcmTypeName( lkpAttachmentTypeDto.getEcmTypeName() );
        }
    }
}
