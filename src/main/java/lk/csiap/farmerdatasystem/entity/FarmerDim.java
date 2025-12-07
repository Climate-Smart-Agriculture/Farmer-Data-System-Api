package lk.csiap.farmerdatasystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    private Long farmerId;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "nic", unique = true, nullable = false)
    private String nic;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "district")
    private String district;

    @Column(name = "province")
    private String province;

    @Column(name = "gn_division")
    private String gnDivision;

    @Column(name = "ds_division")
    private String dsDivision;

    @Column(name = "land_size_hectares")
    private Double landSizeHectares;

    @Column(name = "farming_experience_years")
    private Integer farmingExperienceYears;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
