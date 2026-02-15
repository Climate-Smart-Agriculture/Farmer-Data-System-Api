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
@Table(name = "poultry_farming_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PoultryFarmingData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "poultry_record_pk")
    private Integer poultryRecordPk;

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

    @Column(name = "producer_society")
    private String producerSociety;

    @Column(name = "agricultural_instructor")
    private String agriculturalInstructor;

    @Column(name = "grama_niladhari_division")
    private String gramaNiladhariDivision;

    @Column(name = "chicks_given")
    private Integer chicksGiven;

    @Column(name = "chick_unit_price_rs")
    private BigDecimal chickUnitPriceRs;

    @Column(name = "total_project_cost_rs")
    private BigDecimal totalProjectCostRs;

    @Column(name = "farmer_contribution_rs")
    private BigDecimal farmerContributionRs;

    @Column(name = "total_cost_rs")
    private BigDecimal totalCostRs;

    @Column(name = "dead_chicks")
    private Integer deadChicks;

    @Column(name = "total_egg_production")
    private Integer totalEggProduction;

    @Column(name = "flock_size_increment")
    private Integer flockSizeIncrement;

    @Column(name = "feed_expenditure_rs")
    private BigDecimal feedExpenditureRs;

    @Column(name = "egg_unit_price_rs")
    private BigDecimal eggUnitPriceRs;

    @Column(name = "income_rs")
    private BigDecimal incomeRs;

    @Column(name = "net_income_rs")
    private BigDecimal netIncomeRs;

    @Column(name = "province_code")
    private String provinceCode;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
