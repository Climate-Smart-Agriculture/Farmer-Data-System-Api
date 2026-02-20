package lk.csiap.farmerdatasystem.repository;

import lk.csiap.farmerdatasystem.dto.DistrictCount;
import lk.csiap.farmerdatasystem.entity.PoultryFarmingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoultryRepository
        extends JpaRepository<PoultryFarmingData, Long>, JpaSpecificationExecutor<PoultryFarmingData> {
    List<PoultryFarmingData> findByFarmerId(Long farmerId);

    Long countByDistrict(String district);

    @Query("SELECT p.district AS district, COUNT(p) AS count FROM PoultryFarmingData p WHERE p.district IS NOT NULL GROUP BY p.district")
    List<DistrictCount> countByDistrictGrouped();

    @Query("SELECT COALESCE(SUM(p.incomeRs), 0) FROM PoultryFarmingData p WHERE p.district = :district AND p.incomeRs IS NOT NULL")
    Double sumIncomeByDistrict(@Param("district") String district);
}
