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
@Table(name = "equipment_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipment_record_pk")
    private Integer equipmentRecordPk;

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

    @Column(name = "farmer_organization_name")
    private String farmerOrganizationName;

    @Column(name = "ai_range")
    private String aiRange;

    @Column(name = "grama_niladhari_division")
    private String gramaNiladhariDivision;

    @Column(name = "village_name")
    private String villageName;

    @Column(name = "equipment_name")
    private String equipmentName;

    @Column(name = "equipment_name_standard")
    private String equipmentNameStandard;

    @Column(name = "is_replicated",columnDefinition = "varchar")
    private String isReplicated;

    @Column(name = "no_of_equipment")
    private Integer noOfEquipment;

    @Column(name = "descriptive_extent_ha")
    private String descriptiveExtentHa;

    @Column(name = "extent_ha")
    private BigDecimal extentHa;

    @Column(name = "step_approval_number")
    private String stepApprovalNumber;

    @Column(name = "descriptive_unit_price_rs")
    private String descriptiveUnitPriceRs;

    @Column(name = "unit_price_rs")
    private BigDecimal unitPriceRs;

    @Column(name = "total_project_cost_rs")
    private BigDecimal totalProjectCostRs;

    @Column(name = "descriptive_farmer_cost_rs")
    private String descriptiveFarmerCostRs;

    @Column(name = "farmer_cost_rs")
    private BigDecimal farmerCostRs;

    @Column(name = "province_code")
    private String provinceCode;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
