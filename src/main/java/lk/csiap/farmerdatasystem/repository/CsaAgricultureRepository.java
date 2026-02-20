package lk.csiap.farmerdatasystem.repository;

import lk.csiap.farmerdatasystem.dto.DistrictCount;
import lk.csiap.farmerdatasystem.dto.DistrictYield;
import lk.csiap.farmerdatasystem.entity.CsaAgricultureData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CsaAgricultureRepository
        extends JpaRepository<CsaAgricultureData, Long>, JpaSpecificationExecutor<CsaAgricultureData> {
    List<CsaAgricultureData> findByFarmerId(Long farmerId);

    @Query("SELECT COALESCE(SUM(c.yieldKg), 0) FROM CsaAgricultureData c WHERE c.yieldKg IS NOT NULL")
    Double sumTotalYield();

    Long countByDistrict(String district);

    @Query("SELECT c.district AS district, COUNT(c) AS count FROM CsaAgricultureData c WHERE c.district IS NOT NULL GROUP BY c.district")
    List<DistrictCount> countByDistrictGrouped();

    @Query("SELECT COALESCE(SUM(c.yieldKg), 0) FROM CsaAgricultureData c WHERE c.district = :district AND c.yieldKg IS NOT NULL")
    Double sumYieldByDistrict(@Param("district") String district);

    @Query("SELECT COALESCE(SUM(c.incomeRs), 0) FROM CsaAgricultureData c WHERE c.district = :district AND c.incomeRs IS NOT NULL")
    Double sumIncomeByDistrict(@Param("district") String district);

    @Query("SELECT c.district AS district, COALESCE(SUM(c.yieldKg), 0) AS totalYield, COALESCE(SUM(c.incomeRs), 0) AS totalIncome FROM CsaAgricultureData c WHERE c.district IS NOT NULL GROUP BY c.district")
    List<DistrictYield> sumYieldAndIncomeByDistrictGrouped();
}
