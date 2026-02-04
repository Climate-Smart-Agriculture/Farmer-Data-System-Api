package lk.csiap.farmerdatasystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "poultry_farming_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PoultryFarmingData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "poultry_id")
    private Long poultryId;

    @Column(name = "farmer_id", nullable = false)
    private Long farmerId;

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

    @Column(name = "producer_society")
    private String producerSociety;

    @Column(name = "agricultural_instructor")
    private String agriculturalInstructor;

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

    @Column(name = "chicks_given")
    private Integer chicksGiven;

    @Column(name = "is_csa_conducted")
    private Integer isCsaConducted;

    @Column(name = "is_iec_conducted")
    private Integer isIecConducted;

    @Column(name = "chick_unit_price_rs")
    private Double chickUnitPriceRs;

    @Column(name = "total_project_cost_rs")
    private Double totalProjectCostRs;

    @Column(name = "farmer_contribution_rs")
    private Double farmerContributionRs;

    @Column(name = "total_cost_rs")
    private Double totalCostRs;

    @Column(name = "dead_chicks")
    private Integer deadChicks;

    @Column(name = "total_egg_production")
    private Integer totalEggProduction;

    @Column(name = "flock_size_increment")
    private Integer flockSizeIncrement;

    @Column(name = "feed_expenditure_rs")
    private Double feedExpenditureRs;

    @Column(name = "egg_unit_price_rs")
    private Double eggUnitPriceRs;

    @Column(name = "income_rs")
    private Double incomeRs;

    @Column(name = "net_income_rs")
    private Double netIncomeRs;

    @Column(name = "province_code")
    private String provinceCode;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
