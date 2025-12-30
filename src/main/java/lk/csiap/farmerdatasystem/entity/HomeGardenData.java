package lk.csiap.farmerdatasystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "home_garden_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeGardenData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "home_garden_id")
    private Long homeGardenId;

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

    @Column(name = "producer_society")
    private String producerSociety;

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

    @Column(name = "is_csa_conducted")
    private Integer isCsaConducted;

    @Column(name = "is_iec_conducted")
    private Integer isIecConducted;

    @Column(name = "extent_ha")
    private Double extentHa;

    @Column(name = "seed_pack_count")
    private Integer seedPackCount;

    @Column(name = "banana_plants_count")
    private Integer bananaPlantsCount;

    @Column(name = "papaya_plants_count")
    private Integer papayaPlantsCount;

    @Column(name = "passionfruit_plants_count")
    private Integer passionfruitPlantsCount;

    @Column(name = "lemon_plants_count")
    private Integer lemonPlantsCount;

    @Column(name = "compost_bags_25kg_count")
    private Integer compostBags25kgCount;

    @Column(name = "grow_bags_count")
    private Integer growBagsCount;

    @Column(name = "total_project_cost_rs")
    private Double totalProjectCostRs;

    @Column(name = "vegetable_production_kg")
    private Double vegetableProductionKg;

    @Column(name = "home_consumption_kg")
    private Double homeConsumptionKg;

    @Column(name = "share_with_neighbors_kg")
    private Double shareWithNeighborsKg;

    @Column(name = "sold_quantity_kg")
    private Double soldQuantityKg;

    @Column(name = "sold_price_rs")
    private Double soldPriceRs;

    @Column(name = "income_rs")
    private Double incomeRs;

    @Column(name = "mango_count")
    private Integer mangoCount;

    @Column(name = "orange_count")
    private Integer orangeCount;

    @Column(name = "hand_spade_count")
    private Integer handSpadeCount;

    @Column(name = "hand_fork_count")
    private Integer handForkCount;

    @Column(name = "secateurs_count")
    private Integer secateursCount;

    @Column(name = "pvc_tank_500ml_count")
    private Integer pvcTank500mlCount;

    @Column(name = "watering_can_count")
    private Integer wateringCanCount;

    @Column(name = "mulching_mat_count")
    private Integer mulchingMatCount;

    @Column(name = "nursery_trays_count")
    private Integer nurseryTraysCount;

    @Column(name = "black_polythene_count")
    private Integer blackPolytheneCount;

    @Column(name = "gross_income_rs")
    private Double grossIncomeRs;

    @Column(name = "new_cultivation_1")
    private String newCultivation1;

    @Column(name = "new_cultivation_2")
    private String newCultivation2;

    @Column(name = "new_cultivation_3")
    private String newCultivation3;

    @Column(name = "new_cultivation_4")
    private String newCultivation4;

    @Column(name = "new_cultivation_5")
    private String newCultivation5;

    @Column(name = "new_cultivation_6")
    private String newCultivation6;

    @Column(name = "new_cultivation_7")
    private String newCultivation7;

    @Column(name = "new_cultivation_8")
    private String newCultivation8;

    @Column(name = "new_cultivation_9")
    private String newCultivation9;

    @Column(name = "new_cultivation_10")
    private String newCultivation10;

    @Column(name = "new_cultivation_11")
    private String newCultivation11;

    @Column(name = "new_cultivation_12")
    private String newCultivation12;

    @Column(name = "new_cultivation_13")
    private String newCultivation13;

    @Column(name = "new_cultivation_14")
    private String newCultivation14;

    @Column(name = "new_cultivation_15")
    private String newCultivation15;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
