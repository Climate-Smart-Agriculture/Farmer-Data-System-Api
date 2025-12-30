package lk.csiap.farmerdatasystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "csa_agriculture_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CsaAgricultureData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "csa_agriculture_id")
    private Long csaAgricultureId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farmer_id", nullable = false)
    private FarmerDim farmer;

    @Column(name = "year")
    private Integer year;

    @Column(name = "program_name")
    private String programName;

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

    @Column(name = "grama_niladhari_division")
    private String gramaNiladhariDivision;

    @Column(name = "village_name")
    private String villageName;

    @Column(name = "farmer_name")
    private String farmerName;

    @Column(name = "address")
    private String address;

    @Column(name = "nic_number")
    private String nicNumber;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    @Column(name = "is_female")
    private Integer isFemale;

    @Column(name = "is_male")
    private Integer isMale;

    @Column(name = "is_samurdhi_beneficiary")
    private Integer isSamurdhiBeneficiary;

    @Column(name = "is_woman_headed_household")
    private Integer isWomanHeadedHousehold;

    @Column(name = "is_disabled")
    private Integer isDisabled;

    @Column(name = "crop_type")
    private String cropType;

    @Column(name = "is_replicated_crop")
    private Integer isReplicatedCrop;

    @Column(name = "grown_irrigated_paddy_indicator")
    private Integer grownIrrigatedPaddyIndicator;

    @Column(name = "grown_rainfed_paddy_indicator")
    private Integer grownRainfedPaddyIndicator;

    @Column(name = "grown_irrigated_highland_indicator")
    private Integer grownIrrigatedHighlandIndicator;

    @Column(name = "grown_rainfed_highland_indicator")
    private Integer grownRainfedHighlandIndicator;

    @Column(name = "csa_crop_diversification")
    private Integer csaCropDiversification;

    @Column(name = "csa_seed_production")
    private Integer csaSeedProduction;

    @Column(name = "csa_interseason")
    private Integer csaInterseason;

    @Column(name = "csa_micro_irrigation")
    private Integer csaMicroIrrigation;

    @Column(name = "csa_home_gardening")
    private Integer csaHomeGardening;

    @Column(name = "csa_agronomic_interventions")
    private Integer csaAgronomicInterventions;

    @Column(name = "csa_training_received")
    private Integer csaTrainingReceived;

    @Column(name = "iec_conducted")
    private Integer iecConducted;

    @Column(name = "fts_training")
    private Integer ftsTraining;

    @Column(name = "fbs_training")
    private Integer fbsTraining;

    @Column(name = "variety_name")
    private String varietyName;

    @Column(name = "seed_quantity_kg")
    private Double seedQuantityKg;

    @Column(name = "extent_ha")
    private Double extentHa;

    @Column(name = "pre_losses_ha")
    private Double preLossesHa;

    @Column(name = "harvested_area_ha")
    private Double harvestedAreaHa;

    @Column(name = "seed_unit_price_rs")
    private Double seedUnitPriceRs;

    @Column(name = "project_seed_expense_rs")
    private Double projectSeedExpenseRs;

    @Column(name = "farmer_contribution_seed_rs")
    private Double farmerContributionSeedRs;

    @Column(name = "total_seed_cost_rs")
    private Double totalSeedCostRs;

    @Column(name = "farmer_cost_rs")
    private Double farmerCostRs;

    @Column(name = "total_cultivation_cost_rs")
    private Double totalCultivationCostRs;

    @Column(name = "post_losses_kg")
    private Double postLossesKg;

    @Column(name = "yield_kg")
    private Double yieldKg;

    @Column(name = "sold_unit_price_rs")
    private Double soldUnitPriceRs;

    @Column(name = "income_rs")
    private Double incomeRs;

    @Column(name = "net_income_rs")
    private Double netIncomeRs;

    @Column(name = "productivity_kg_per_ha")
    private Double productivityKgPerHa;

    @Column(name = "baseline_productivity_kg_per_ha")
    private Double baselineProductivityKgPerHa;

    @Column(name = "yield_increase_mt")
    private Double yieldIncreaseMt;

    @Column(name = "yield_increase_percent")
    private Double yieldIncreasePercent;

    @Column(name = "baseline_price_rs_per_kg")
    private Double baselinePriceRsPerKg;

    @Column(name = "baseline_value_per_ha_rs")
    private Double baselineValuePerHaRs;

    @Column(name = "productivity_value_per_ha_rs")
    private Double productivityValuePerHaRs;

    @Column(name = "incremental_productivity_value_rs")
    private Double incrementalProductivityValueRs;

    @Column(name = "cdi_score")
    private Double cdiScore;

    @Column(name = "cropping_intensity_percent")
    private Double croppingIntensityPercent;

    @Column(name = "province_code")
    private String provinceCode;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
