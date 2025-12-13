package lk.csiap.farmerdatasystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class AgricultureFactRequestDTO {

    // Using validation annotations for robustness
    @NotBlank(message = "Season/Month is required")
    private String seasonMonth;

    @NotBlank(message = "District is required")
    private String district;

    private String dsdDivision;
    private String ascDivision;
    private String cascadeName;
    private String tankOrVisName;

    @NotNull(message = "Command Area is required")
    private Double commandAreaHa;

    // ... all other fields as in the Response DTO, excluding recordId ...

    private String producerSociety;
    private String farmerOrganizationName;
    private String aiRange;
    private String gnd;

    @NotBlank(message = "Farmer Name is required")
    private String nameofthefarmer;

    private String address;

    @NotBlank(message = "NIC number is required")
    private String idno;

    private String telephoneno;
    private String female;
    private String male;
    private String samurdhi;
    private String womanhead;
    private String disable;
    private String cropcultivated;
    private Integer isReplicatedCrop;

    @NotNull(message = "Extent is required")
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