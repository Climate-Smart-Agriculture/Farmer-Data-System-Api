package lk.csiap.farmerdatasystem.repository;

import lk.csiap.farmerdatasystem.dto.DistrictCount;
import lk.csiap.farmerdatasystem.entity.HomeGardenData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeGardenRepository
        extends JpaRepository<HomeGardenData, Long>, JpaSpecificationExecutor<HomeGardenData> {
    List<HomeGardenData> findByFarmerId(Long farmerId);

    Long countByDistrict(String district);

    @Query("SELECT h.district AS district, COUNT(h) AS count FROM HomeGardenData h WHERE h.district IS NOT NULL GROUP BY h.district")
    List<DistrictCount> countByDistrictGrouped();

    @Query("SELECT COALESCE(SUM(h.incomeRs), 0) FROM HomeGardenData h WHERE h.district = :district AND h.incomeRs IS NOT NULL")
    Double sumIncomeByDistrict(@Param("district") String district);
}
