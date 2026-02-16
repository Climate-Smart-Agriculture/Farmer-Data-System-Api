package lk.csiap.farmerdatasystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "csa_agriculture_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CsaAgricultureData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "csa_record_pk")
    private Integer csaRecordPk;

    @Column(name = "record_id")
    private Integer recordId;

    @Column(name = "farmer_id", nullable = false)
    private Integer farmerId;

    @Column(name = "year")
    private String year;

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
    private String commandAreaHa;

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

    @Column(name = "crop_type")
    private String cropType;

    @Column(name = "is_replicated_crop", columnDefinition = "varchar")
    private String isReplicatedCrop;

    @Column(name = "grown_irrigated_paddy_indicator")
    private String grownIrrigatedPaddyIndicator;

    @Column(name = "grown_rainfed_paddy_indicator")
    private String grownRainfedPaddyIndicator;

    @Column(name = "grown_irrigated_highland_indicator")
    private String grownIrrigatedHighlandIndicator;

    @Column(name = "grown_rainfed_highland_indicator")
    private String grownRainfedHighlandIndicator;

    @Column(name = "csa_crop_diversification")
    private String csaCropDiversification;

    @Column(name = "csa_seed_production")
    private String csaSeedProduction;

    @Column(name = "csa_interseason")
    private String csaInterseason;

    @Column(name = "csa_micro_irrigation")
    private String csaMicroIrrigation;

    @Column(name = "csa_home_gardening")
    private String csaHomeGardening;

    @Column(name = "csa_agronomic_interventions")
    private String csaAgronomicInterventions;

    @Column(name = "fts_training")
    private String ftsTraining;

    @Column(name = "fbs_training")
    private String fbsTraining;

    @Column(name = "variety_name")
    private String varietyName;

    @Column(name = "seed_quantity_kg")
    private BigDecimal seedQuantityKg;

    @Column(name = "extent_ha")
    private BigDecimal extentHa;

    @Column(name = "pre_losses_ha")
    private BigDecimal preLossesHa;

    @Column(name = "harvested_area_ha")
    private BigDecimal harvestedAreaHa;

    @Column(name = "seed_unit_price_rs")
    private BigDecimal seedUnitPriceRs;

    @Column(name = "project_seed_expense_rs")
    private BigDecimal projectSeedExpenseRs;

    @Column(name = "farmer_contribution_seed_rs")
    private BigDecimal farmerContributionSeedRs;

    @Column(name = "total_seed_cost_rs")
    private BigDecimal totalSeedCostRs;

    @Column(name = "farmer_cost_rs")
    private BigDecimal farmerCostRs;

    @Column(name = "total_cultivation_cost_rs")
    private BigDecimal totalCultivationCostRs;

    @Column(name = "post_losses_kg")
    private BigDecimal postLossesKg;

    @Column(name = "yield_kg")
    private BigDecimal yieldKg;

    @Column(name = "sold_unit_price_rs")
    private BigDecimal soldUnitPriceRs;

    @Column(name = "income_rs")
    private BigDecimal incomeRs;

    @Column(name = "net_income_rs")
    private BigDecimal netIncomeRs;

    @Column(name = "productivity_kg_per_ha")
    private BigDecimal productivityKgPerHa;

    @Column(name = "baseline_productivity_kg_per_ha")
    private BigDecimal baselineProductivityKgPerHa;

    @Column(name = "yield_increase_mt")
    private BigDecimal yieldIncreaseMt;

    @Column(name = "yield_increase_percent")
    private String yieldIncreasePercent;

    @Column(name = "baseline_price_rs_per_kg")
    private BigDecimal baselinePriceRsPerKg;

    @Column(name = "baseline_value_per_ha_rs")
    private BigDecimal baselineValuePerHaRs;

    @Column(name = "productivity_value_per_ha_rs")
    private BigDecimal productivityValuePerHaRs;

    @Column(name = "incremental_productivity_percent")
    private String incrementalProductivityPercent;

    @Column(name = "cdi_score")
    private BigDecimal cdiScore;

    @Column(name = "cropping_intensity_percent")
    private String croppingIntensityPercent;

    @Column(name = "province_code")
    private String provinceCode;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
