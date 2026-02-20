package lk.csiap.farmerdatasystem.repository;

import lk.csiap.farmerdatasystem.dto.DistrictCount;
import lk.csiap.farmerdatasystem.dto.DistrictYield;
import lk.csiap.farmerdatasystem.entity.AgroWellData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgroWellRepository extends JpaRepository<AgroWellData, Long>, JpaSpecificationExecutor<AgroWellData> {
    List<AgroWellData> findByFarmerId(Long farmerId);

    @Query("SELECT COALESCE(SUM(a.yieldKg), 0) FROM AgroWellData a WHERE a.yieldKg IS NOT NULL")
    Double sumTotalYield();

    Long countByDistrict(String district);

    @Query("SELECT a.district AS district, COUNT(a) AS count FROM AgroWellData a WHERE a.district IS NOT NULL GROUP BY a.district")
    List<DistrictCount> countByDistrictGrouped();

    @Query("SELECT COALESCE(SUM(a.yieldKg), 0) FROM AgroWellData a WHERE a.district = :district AND a.yieldKg IS NOT NULL")
    Double sumYieldByDistrict(@Param("district") String district);

    @Query("SELECT COALESCE(SUM(a.incomeRs), 0) FROM AgroWellData a WHERE a.district = :district AND a.incomeRs IS NOT NULL")
    Double sumIncomeByDistrict(@Param("district") String district);

    @Query("SELECT a.district AS district, COALESCE(SUM(a.yieldKg), 0) AS totalYield, COALESCE(SUM(a.incomeRs), 0) AS totalIncome FROM AgroWellData a WHERE a.district IS NOT NULL GROUP BY a.district")
    List<DistrictYield> sumYieldAndIncomeByDistrictGrouped();
}
