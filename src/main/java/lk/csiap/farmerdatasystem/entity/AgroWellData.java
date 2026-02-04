package lk.csiap.farmerdatasystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "agro_well_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgroWellData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agro_well_id")
    private Long agroWellId;

    @Column(name = "farmer_id", nullable = false)
    private Long farmerId;

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

    @Column(name = "cultivations")
    private String cultivations;

    @Column(name = "is_replicated_crop")
    private Integer isReplicatedCrop;

    @Column(name = "extent_ha")
    private Double extentHa;

    @Column(name = "no_of_plant")
    private Integer noOfPlant;

    @Column(name = "total_cultivation_cost_rs")
    private Double totalCultivationCostRs;

    @Column(name = "agrowell_depreciation_per_season_cost_rs")
    private Double agrowellDepreciationPerSeasonCostRs;

    @Column(name = "total_cost_rs")
    private Double totalCostRs;

    @Column(name = "yield_kg")
    private Double yieldKg;

    @Column(name = "income_rs")
    private Double incomeRs;

    @Column(name = "net_income_rs")
    private Double netIncomeRs;

    @Column(name = "irrigation_method")
    private String irrigationMethod;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
