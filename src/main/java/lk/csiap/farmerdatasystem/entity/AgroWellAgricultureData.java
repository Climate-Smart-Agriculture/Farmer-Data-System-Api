package lk.csiap.farmerdatasystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "agro_well_agriculture_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgroWellAgricultureData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agro_well_id")
    private Long agroWellId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farmer_id", nullable = false)
    private FarmerDim farmer;

    @Column(name = "well_number")
    private String wellNumber;

    @Column(name = "well_depth_meters")
    private Double wellDepthMeters;

    @Column(name = "water_capacity_cubic_meters")
    private Double waterCapacityCubicMeters;

    @Column(name = "pump_type")
    private String pumpType;

    @Column(name = "pump_power_hp")
    private Double pumpPowerHp;

    @Column(name = "irrigated_area_hectares")
    private Double irrigatedAreaHectares;

    @Column(name = "crop_type")
    private String cropType;

    @Column(name = "crop_variety")
    private String cropVariety;

    @Column(name = "planting_date")
    private LocalDateTime plantingDate;

    @Column(name = "expected_harvest_date")
    private LocalDateTime expectedHarvestDate;

    @Column(name = "actual_harvest_date")
    private LocalDateTime actualHarvestDate;

    @Column(name = "yield_kg")
    private Double yieldKg;

    @Column(name = "water_usage_hours_per_day")
    private Double waterUsageHoursPerDay;

    @Column(name = "electricity_cost")
    private Double electricityCost;

    @Column(name = "maintenance_cost")
    private Double maintenanceCost;

    @Column(name = "notes")
    private String notes;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
