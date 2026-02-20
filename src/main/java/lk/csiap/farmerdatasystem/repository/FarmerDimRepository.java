package lk.csiap.farmerdatasystem.repository;

import lk.csiap.farmerdatasystem.dto.DistrictCount;
import lk.csiap.farmerdatasystem.entity.FarmerDim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FarmerDimRepository extends JpaRepository<FarmerDim, Long>,
        JpaSpecificationExecutor<FarmerDim> {
    Optional<FarmerDim> findByNicNumber(String nicNumber);

    Boolean existsByNicNumber(String nicNumber);

    Long countByDistrict(String district);

    @Query("SELECT f.district AS district, COUNT(f) AS count FROM FarmerDim f WHERE f.district IS NOT NULL GROUP BY f.district ORDER BY COUNT(f) DESC")
    List<DistrictCount> countByDistrictGrouped();

    @Query("SELECT DISTINCT f.district FROM FarmerDim f WHERE f.district IS NOT NULL ORDER BY f.district")
    List<String> findAllDistricts();
}
