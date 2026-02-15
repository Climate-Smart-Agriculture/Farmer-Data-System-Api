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
@Table(name = "farmer_dim")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmerDim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "farmer_id")
    private Integer farmerId;

    @Column(name = "farmer_name", nullable = false)
    private String farmerName;

    @Column(name = "nic_number", unique = true, nullable = false)
    private String nicNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "district")
    private String district;

    @Column(name = "village_name")
    private String villageName;

    @Column(name = "dsd_division")
    private String dsdDivision;

    @Column(name = "asc_division")
    private String ascDivision;

    @Column(name = "ai_range")
    private String aiRange;

    @Column(name = "grama_niladhari_division")
    private String gramaNiladhariDivision;

    @Column(name = "cascade_name")
    private String cascadeName;

    @Column(name = "tank_or_vis_name")
    private String tankOrVisName;

    @Column(name = "producer_society")
    private String producerSociety;

    @Column(name = "farmer_organization_name")
    private String farmerOrganizationName;

    @Column(name = "command_area_ha")
    private BigDecimal commandAreaHa;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    @Column(name = "gender")
    private String gender;

    @Column(name = "is_samurdhi_beneficiary")
    private String isSamurdhiBeneficiary;

    @Column(name = "is_woman_headed_household")
    private String isWomanHeadedHousehold;

    @Column(name = "is_disabled")
    private String isDisabled;

    @Column(name = "is_csa_conducted")
    private String isCsaConducted;

    @Column(name = "is_iec_conducted")
    private String isIecConducted;

    @Column(name = "fts_training")
    private String ftsTraining;

    @Column(name = "fbs_training")
    private String fbsTraining;

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

    @Column(name = "province_code")
    private String provinceCode;

    @CreationTimestamp
    @Column(name = "inserted_at", nullable = false, updatable = false)
    private LocalDateTime insertedAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
