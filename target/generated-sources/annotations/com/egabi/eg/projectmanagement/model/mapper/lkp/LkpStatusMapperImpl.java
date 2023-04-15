package com.egabi.eg.projectmanagement.model.mapper.lkp;

import com.egabi.eg.projectmanagement.model.entities.lkp.LkpStatus;
import com.egabi.eg.projectmanagement.model.mapper.dto.LkpStatusDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-05T07:53:54+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class LkpStatusMapperImpl implements LkpStatusMapper {

    @Override
    public LkpStatus lkpStatusDtoToLkpStatus(LkpStatusDto lkpStatusDto) {
        if ( lkpStatusDto == null ) {
            return null;
        }

        LkpStatus lkpStatus = new LkpStatus();

        lkpStatus.setId( lkpStatusDto.getId() );
        lkpStatus.setNameEn( lkpStatusDto.getNameEn() );
        lkpStatus.setNameAr( lkpStatusDto.getNameAr() );
        lkpStatus.setStatusType( lkpStatusDto.getStatusType() );

        return lkpStatus;
    }

    @Override
    public LkpStatusDto lkpStatusToLkpStatusDto(LkpStatus lkpStatus) {
        if ( lkpStatus == null ) {
            return null;
        }

        Long id = null;
        String nameEn = null;
        String nameAr = null;
        String statusType = null;

        id = lkpStatus.getId();
        nameEn = lkpStatus.getNameEn();
        nameAr = lkpStatus.getNameAr();
        statusType = lkpStatus.getStatusType();

        Boolean isDeleted = null;

        LkpStatusDto lkpStatusDto = new LkpStatusDto( id, isDeleted, nameEn, nameAr, statusType );

        return lkpStatusDto;
    }

    @Override
    public void updateLkpStatusFromLkpStatusDto(LkpStatusDto lkpStatusDto, LkpStatus lkpStatus) {
        if ( lkpStatusDto == null ) {
            return;
        }

        if ( lkpStatusDto.getId() != null ) {
            lkpStatus.setId( lkpStatusDto.getId() );
        }
        if ( lkpStatusDto.getNameEn() != null ) {
            lkpStatus.setNameEn( lkpStatusDto.getNameEn() );
        }
        if ( lkpStatusDto.getNameAr() != null ) {
            lkpStatus.setNameAr( lkpStatusDto.getNameAr() );
        }
        if ( lkpStatusDto.getStatusType() != null ) {
            lkpStatus.setStatusType( lkpStatusDto.getStatusType() );
        }
    }
}
