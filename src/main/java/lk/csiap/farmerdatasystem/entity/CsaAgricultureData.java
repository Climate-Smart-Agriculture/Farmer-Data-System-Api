package lk.csiap.farmerdatasystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "csa_agriculture_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CsaAgricultureData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "csa_agriculture_id")
    private Long csaAgricultureId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farmer_id", nullable = false)
    private FarmerDim farmer;

    @Column(name = "crop_type", nullable = false)
    private String cropType;

    @Column(name = "crop_variety")
    private String cropVariety;

    @Column(name = "cultivation_area_hectares")
    private Double cultivationAreaHectares;

    @Column(name = "season")
    private String season;

    @Column(name = "planting_date")
    private LocalDateTime plantingDate;

    @Column(name = "expected_harvest_date")
    private LocalDateTime expectedHarvestDate;

    @Column(name = "actual_harvest_date")
    private LocalDateTime actualHarvestDate;

    @Column(name = "yield_kg")
    private Double yieldKg;

    @Column(name = "irrigation_type")
    private String irrigationType;

    @Column(name = "water_source")
    private String waterSource;

    @Column(name = "climate_smart_practices")
    private String climateSmartPractices;

    @Column(name = "fertilizer_type")
    private String fertilizerType;

    @Column(name = "pesticide_type")
    private String pesticideType;

    @Column(name = "production_cost")
    private Double productionCost;

    @Column(name = "market_price_per_kg")
    private Double marketPricePerKg;

    @Column(name = "notes")
    private String notes;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
