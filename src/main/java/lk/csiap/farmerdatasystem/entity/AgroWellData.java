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
@Table(name = "agro_well_agriculture_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgroWellData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agro_well_pk")
    private Integer agroWellPk;

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
    private BigDecimal commandAreaHa;

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

    @Column(name = "cultivations")
    private String cultivations;

    @Column(name = "is_replicated_crop")
    private Character isReplicatedCrop;

    @Column(name = "extent_ha")
    private BigDecimal extentHa;

    @Column(name = "no_of_plant")
    private BigDecimal noOfPlant;

    @Column(name = "total_cultivation_cost_rs")
    private BigDecimal totalCultivationCostRs;

    @Column(name = "agrowell_depreciation_per_season_cost_rs")
    private BigDecimal agrowellDepreciationPerSeasonCostRs;

    @Column(name = "total_cost_rs")
    private BigDecimal totalCostRs;

    @Column(name = "yield_kg")
    private BigDecimal yieldKg;

    @Column(name = "income_rs")
    private BigDecimal incomeRs;

    @Column(name = "net_income_rs")
    private BigDecimal netIncomeRs;

    @Column(name = "irrigation_method")
    private String irrigationMethod;

    @Column(name = "province_code")
    private String provinceCode;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
