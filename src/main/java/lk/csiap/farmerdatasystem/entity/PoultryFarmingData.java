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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farmer_id", nullable = false)
    private FarmerDim farmer;

    @Column(name = "poultry_type", nullable = false)
    private String poultryType;

    @Column(name = "breed")
    private String breed;

    @Column(name = "bird_count")
    private Integer birdCount;

    @Column(name = "batch_date")
    private LocalDateTime batchDate;

    @Column(name = "housing_type")
    private String housingType;

    @Column(name = "feeding_method")
    private String feedingMethod;

    @Column(name = "feed_cost_per_month")
    private Double feedCostPerMonth;

    @Column(name = "egg_production_per_day")
    private Integer eggProductionPerDay;

    @Column(name = "meat_production_kg")
    private Double meatProductionKg;

    @Column(name = "mortality_count")
    private Integer mortalityCount;

    @Column(name = "vaccination_status")
    private String vaccinationStatus;

    @Column(name = "health_issues")
    private String healthIssues;

    @Column(name = "revenue_per_month")
    private Double revenuePerMonth;

    @Column(name = "notes")
    private String notes;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
