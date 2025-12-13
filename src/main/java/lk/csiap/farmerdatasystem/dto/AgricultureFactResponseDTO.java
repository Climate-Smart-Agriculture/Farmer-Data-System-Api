package lk.csiap.farmerdatasystem.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class AgricultureFactResponseDTO {

    private Long recordId;

    private String seasonMonth;
    private String district;
    private String dsdDivision;
    private String ascDivision;
    private String cascadeName;
    private String tankOrVisName;
    private Double commandAreaHa;
    private String producerSociety;
    private String farmerOrganizationName;
    private String aiRange;
    private String gnd;

    private String nameofthefarmer;
    private String address;
    private String idno;
    private String telephoneno;
    private String female;
    private String male;
    private String samurdhi;
    private String womanhead;
    private String disable;

    private String cropcultivated;
    private Integer isReplicatedCrop;
    private Double extentHa;
    private Integer noOfPlant;

    private BigDecimal totalCultivationCostRs;
    private BigDecimal agrowellDepreciationPerSeasonCostRs;
    private BigDecimal totalcost;
    private Double yieldKg;
    private BigDecimal incomeRs;
    private BigDecimal netIncomeRs;

    private String irrigationmethod;
}