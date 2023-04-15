package com.egabi.eg.projectmanagement.model.mapper.lkp;

import com.egabi.eg.projectmanagement.model.entities.lkp.LkpBusinessSubLine;
import com.egabi.eg.projectmanagement.model.mapper.dto.LkpBusinessSubLineDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-05T07:53:53+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class LkpBusinessSubLineMapperImpl implements LkpBusinessSubLineMapper {

    @Override
    public LkpBusinessSubLine lkpBusinessSubLineDtoToLkpBusinessSubLine(LkpBusinessSubLineDto lkpBusinessSubLineDto) {
        if ( lkpBusinessSubLineDto == null ) {
            return null;
        }

        LkpBusinessSubLine lkpBusinessSubLine = new LkpBusinessSubLine();

        lkpBusinessSubLine.setId( lkpBusinessSubLineDto.getId() );
        lkpBusinessSubLine.setNameEn( lkpBusinessSubLineDto.getNameEn() );
        lkpBusinessSubLine.setNameAr( lkpBusinessSubLineDto.getNameAr() );

        return lkpBusinessSubLine;
    }

    @Override
    public LkpBusinessSubLineDto lkpBusinessSubLineToLkpBusinessSubLineDto(LkpBusinessSubLine lkpBusinessSubLine) {
        if ( lkpBusinessSubLine == null ) {
            return null;
        }

        Long id = null;
        String nameEn = null;
        String nameAr = null;

        id = lkpBusinessSubLine.getId();
        nameEn = lkpBusinessSubLine.getNameEn();
        nameAr = lkpBusinessSubLine.getNameAr();

        Boolean isDeleted = null;

        LkpBusinessSubLineDto lkpBusinessSubLineDto = new LkpBusinessSubLineDto( id, isDeleted, nameEn, nameAr );

        return lkpBusinessSubLineDto;
    }

    @Override
    public void updateLkpBusinessSubLineFromLkpBusinessSubLineDto(LkpBusinessSubLineDto lkpBusinessSubLineDto, LkpBusinessSubLine lkpBusinessSubLine) {
        if ( lkpBusinessSubLineDto == null ) {
            return;
        }

        if ( lkpBusinessSubLineDto.getId() != null ) {
            lkpBusinessSubLine.setId( lkpBusinessSubLineDto.getId() );
        }
        if ( lkpBusinessSubLineDto.getNameEn() != null ) {
            lkpBusinessSubLine.setNameEn( lkpBusinessSubLineDto.getNameEn() );
        }
        if ( lkpBusinessSubLineDto.getNameAr() != null ) {
            lkpBusinessSubLine.setNameAr( lkpBusinessSubLineDto.getNameAr() );
        }
    }
}
