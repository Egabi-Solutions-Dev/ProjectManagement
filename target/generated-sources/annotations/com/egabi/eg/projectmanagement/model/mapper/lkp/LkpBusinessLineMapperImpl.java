package com.egabi.eg.projectmanagement.model.mapper.lkp;

import com.egabi.eg.projectmanagement.model.entities.lkp.LkpBusinessLine;
import com.egabi.eg.projectmanagement.model.mapper.dto.LkpBusinessLineDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-05T07:53:53+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 13.0.2 (Oracle Corporation)"
)
@Component
public class LkpBusinessLineMapperImpl implements LkpBusinessLineMapper {

    @Override
    public LkpBusinessLine lkpBusinessLineDtoTolkpBusinessLine(LkpBusinessLineDto lkpBusinessLineDto) {
        if ( lkpBusinessLineDto == null ) {
            return null;
        }

        LkpBusinessLine lkpBusinessLine = new LkpBusinessLine();

        lkpBusinessLine.setId( lkpBusinessLineDto.getId() );
        lkpBusinessLine.setNameEn( lkpBusinessLineDto.getNameEn() );
        lkpBusinessLine.setNameAr( lkpBusinessLineDto.getNameAr() );

        return lkpBusinessLine;
    }

    @Override
    public LkpBusinessLineDto lkpBusinessLineToLkpBusinessLineDto(LkpBusinessLine lkpBusinessLine) {
        if ( lkpBusinessLine == null ) {
            return null;
        }

        Long id = null;
        String nameEn = null;
        String nameAr = null;

        id = lkpBusinessLine.getId();
        nameEn = lkpBusinessLine.getNameEn();
        nameAr = lkpBusinessLine.getNameAr();

        Boolean isDeleted = null;

        LkpBusinessLineDto lkpBusinessLineDto = new LkpBusinessLineDto( id, isDeleted, nameEn, nameAr );

        return lkpBusinessLineDto;
    }

    @Override
    public void updatelkpBusinessLineFromLkpBusinessLineDto(LkpBusinessLineDto lkpBusinessLineDto, LkpBusinessLine lkpBusinessLine) {
        if ( lkpBusinessLineDto == null ) {
            return;
        }

        if ( lkpBusinessLineDto.getId() != null ) {
            lkpBusinessLine.setId( lkpBusinessLineDto.getId() );
        }
        if ( lkpBusinessLineDto.getNameEn() != null ) {
            lkpBusinessLine.setNameEn( lkpBusinessLineDto.getNameEn() );
        }
        if ( lkpBusinessLineDto.getNameAr() != null ) {
            lkpBusinessLine.setNameAr( lkpBusinessLineDto.getNameAr() );
        }
    }
}
