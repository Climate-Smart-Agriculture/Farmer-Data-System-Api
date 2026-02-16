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
@Table(name = "home_garden_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeGardenData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ehg_record_pk")
    private Integer ehgRecordPk;

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

    @Column(name = "ai_range")
    private String aiRange;

    @Column(name = "grama_niladhari_division")
    private String gramaNiladhariDivision;

    @Column(name = "village_name")
    private String villageName;

    @Column(name = "extent_ha")
    private BigDecimal extentHa;

    @Column(name = "seed_pack_count")
    private BigDecimal seedPackCount;

    @Column(name = "banana_plants_count")
    private BigDecimal bananaPlantsCount;

    @Column(name = "papaya_plants_count")
    private BigDecimal papayaPlantsCount;

    @Column(name = "passionfruit_plants_count")
    private BigDecimal passionfruitPlantsCount;

    @Column(name = "lemon_plants_count")
    private BigDecimal lemonPlantsCount;

    @Column(name = "compost_bags_25kg_count")
    private BigDecimal compostBags25kgCount;

    @Column(name = "grow_bags_count")
    private BigDecimal growBagsCount;

    @Column(name = "total_project_cost_rs")
    private BigDecimal totalProjectCostRs;

    @Column(name = "vegetable_production_kg")
    private BigDecimal vegetableProductionKg;

    @Column(name = "home_consumption_kg")
    private BigDecimal homeConsumptionKg;

    @Column(name = "share_with_neighbors_kg")
    private BigDecimal shareWithNeighborsKg;

    @Column(name = "sold_quantity_kg")
    private BigDecimal soldQuantityKg;

    @Column(name = "sold_price_rs")
    private BigDecimal soldPriceRs;

    @Column(name = "income_rs")
    private BigDecimal incomeRs;

    @Column(name = "mango_count")
    private BigDecimal mangoCount;

    @Column(name = "orange_count")
    private BigDecimal orangeCount;

    @Column(name = "hand_spade_count")
    private BigDecimal handSpadeCount;

    @Column(name = "hand_fork_count")
    private BigDecimal handForkCount;

    @Column(name = "secateurs_count")
    private BigDecimal secateursCount;

    @Column(name = "pvc_tank_500ml_count")
    private BigDecimal pvcTank500mlCount;

    @Column(name = "watering_can_count")
    private BigDecimal wateringCanCount;

    @Column(name = "mulching_mat_count")
    private BigDecimal mulchingMatCount;

    @Column(name = "nursery_trays_count")
    private BigDecimal nurseryTraysCount;

    @Column(name = "black_polythene_count")
    private BigDecimal blackPolytheneCount;

    @Column(name = "gross_income_rs")
    private BigDecimal grossIncomeRs;

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

    @Column(name = "province_code")
    private String provinceCode;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
