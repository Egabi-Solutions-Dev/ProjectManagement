package com.egabi.eg.projectmanagement.model.dto.transactions;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Customer {
   private Long   customerId;
   private String customerCode;
   private String customerNameEn;
   private String customerNameAr;
   private Long   customerRegionId;
   private String customerRegionName;
   private Long   customerCountryId;
   private String customerCountryName;
   private String avatar;
}