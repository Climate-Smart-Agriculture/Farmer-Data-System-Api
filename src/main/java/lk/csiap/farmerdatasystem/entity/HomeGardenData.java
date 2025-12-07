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

    @Column(name = "crop_type", nullable = false)
    private String cropType;

    @Column(name = "crop_variety")
    private String cropVariety;

    @Column(name = "cultivation_area_sqm")
    private Double cultivationAreaSqm;

    @Column(name = "planting_date")
    private LocalDateTime plantingDate;

    @Column(name = "expected_harvest_date")
    private LocalDateTime expectedHarvestDate;

    @Column(name = "actual_harvest_date")
    private LocalDateTime actualHarvestDate;

    @Column(name = "yield_kg")
    private Double yieldKg;

    @Column(name = "irrigation_method")
    private String irrigationMethod;

    @Column(name = "fertilizer_used")
    private String fertilizerUsed;

    @Column(name = "pesticide_used")
    private String pesticideUsed;

    @Column(name = "notes")
    private String notes;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
