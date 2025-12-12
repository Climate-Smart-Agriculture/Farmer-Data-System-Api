package lk.csiap.farmerdatasystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal; // Using BigDecimal for monetary and potentially high-precision values

@Entity
@Table(name = "agriculture_fact")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgricultureFact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Long recordId;

    @Column(name = "program_name")
    private String seasonMonth;

    @Column(name = "district")
    private String district;

    @Column(name = "dsd_division")
    private String dsdDivision;

    @Column(name = "asc_division")
    private String ascDivision;

    @Column(name = "cascade_name")
    private String cascadeName;

    @Column(name = "tank_or_vis_name")
    private String tankOrVisName;

    @Column(name = "command_area_ha")
    private Double commandAreaHa;

    @Column(name = "producer_society")
    private String producerSociety;

    @Column(name = "farmer_organization_name")
    private String farmerOrganizationName;

    @Column(name = "ai_range")
    private String aiRange;

    @Column(name = "grama-niladhari_division")
    private String gnd;

    @Column(name = "farmer_name")
    private String nameofthefarmer;

    @Column(name = "address")
    private String address;

    @Column(name = "nic_number")
    private String idno;

    @Column(name = "telephone_number")
    private String telephoneno;

    @Column(name = "is_female")
    private String female;

    @Column(name = "is_male")
    private String male;

    @Column(name = "is_samurdhi_beneficiary")
    private String samurdhi;

    @Column(name = "is_woman_headed_household")
    private String womanhead;

    @Column(name = "is_disabled")
    private String disable;

    // --- Cultivation Data ---
    @Column(name = "cultivations")
    private String cropcultivated;

    @Column(name = "is_replicated_crop")
    private Integer isReplicatedCrop;

    @Column(name = "extent_ha")
    private Double extentHa;

    @Column(name = "no_of_plant")
    private Integer noOfPlant;

    @Column(name = "total_cultivation_cost_rs", precision = 19, scale = 2)
    private BigDecimal totalCultivationCostRs;

    @Column(name = "agrowell_depreciation_per_season_cost_rs", precision = 19, scale = 2)
    private BigDecimal agrowellDepreciationPerSeasonCostRs;

    @Column(name = "tottal_cost_rs", precision = 19, scale = 2)
    private BigDecimal totalcost; // Corresponds to 'Cost for Dsd'

    @Column(name = "yield_kg")
    private Double yieldKg;

    @Column(name = "income_rs", precision = 19, scale = 2)
    private BigDecimal incomeRs;

    @Column(name = "net_income_rs", precision = 19, scale = 2)
    private BigDecimal netIncomeRs;

    @Column(name = "irrigation_method")
    private BigDecimal irrigationmethod;

}