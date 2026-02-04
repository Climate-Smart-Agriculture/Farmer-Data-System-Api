package lk.csiap.farmerdatasystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "equipment_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipment_id")
    private Long equipmentId;

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

    @Column(name = "equipment_name")
    private String equipmentName;

    @Column(name = "is_replicated")
    private Integer isReplicated;

    @Column(name = "no_of_equipment")
    private Integer noOfEquipment;

    @Column(name = "extent_ha")
    private Double extentHa;

    @Column(name = "step_approval_number")
    private String stepApprovalNumber;

    @Column(name = "unit_price_rs")
    private Double unitPriceRs;

    @Column(name = "total_project_cost_rs")
    private Double totalProjectCostRs;

    @Column(name = "farmer_cost_rs")
    private Double farmerCostRs;

    @Column(name = "province_code")
    private String provinceCode;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
