package com.egabi.eg.projectmanagement;

import com.egabi.eg.projectmanagement.model.entities.lkp.*;
import com.egabi.eg.projectmanagement.model.services.kp.BaseLkpService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LkpServicesConfiguration {

    @Bean(name = "lkpAttachmentTypeService")
    public BaseLkpService<LkpAttachmentType,Long> lkpAttachmentTypeService(){
        BaseLkpService<LkpAttachmentType,Long> baseLkpService = new BaseLkpService<>(LkpAttachmentType.class);
        return baseLkpService;
    }

    @Bean(name = "lkpBusinessLineService")
    public BaseLkpService<LkpBusinessLine,Long> lkpBusinessLineService(){
        BaseLkpService<LkpBusinessLine,Long> baseLkpService = new BaseLkpService<>(LkpBusinessLine.class);
        return baseLkpService;
    }

    @Bean(name = "lkpBusinessSubLineService")
    public BaseLkpService<LkpBusinessSubLine,Long> lkpBusinessSubLineService(){
        BaseLkpService<LkpBusinessSubLine,Long> baseLkpService = new BaseLkpService<>(LkpBusinessSubLine.class);
        return baseLkpService;
    }

    @Bean(name = "lkpCountryService")
    public BaseLkpService<LkpCountry,Long> lkpCountryService(){
        BaseLkpService<LkpCountry,Long> baseLkpService = new BaseLkpService<>(LkpCountry.class);
        return baseLkpService;
    }

    @Bean(name = "lkpCurrencyService")
    public BaseLkpService<LkpCurrency,Long> lkpCurrencyService(){
        BaseLkpService<LkpCurrency,Long> baseLkpService = new BaseLkpService<>(LkpCurrency.class);
        return baseLkpService;
    }

    @Bean(name = "lkpEngagmentTypeService")
    public BaseLkpService<LkpEngagmentType,Long> lkpEngagmentTypeService(){
        BaseLkpService<LkpEngagmentType,Long> baseLkpService = new BaseLkpService<>(LkpEngagmentType.class);
        return baseLkpService;
    }


    @Bean(name = "lkpRegionService")
    public BaseLkpService<LkpRegion,Long> lkpRegionService(){
        BaseLkpService<LkpRegion,Long> baseLkpService = new BaseLkpService<>(LkpRegion.class);
        return baseLkpService;
    }
    @Bean(name = "lkpSectorService")
    public BaseLkpService<LkpSector,Long> lkpSectorService(){
        BaseLkpService<LkpSector,Long> baseLkpService = new BaseLkpService<>(LkpSector.class);
        return baseLkpService;
    }

    @Bean(name = "lkpStatusService")
    public BaseLkpService<LkpStatus,Long> lkpStatusService(){
        BaseLkpService<LkpStatus,Long> baseLkpService = new BaseLkpService<>(LkpStatus.class);
        return baseLkpService;
    }


}
