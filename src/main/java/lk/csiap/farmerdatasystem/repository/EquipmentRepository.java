package lk.csiap.farmerdatasystem.repository;

import lk.csiap.farmerdatasystem.dto.DistrictCount;
import lk.csiap.farmerdatasystem.entity.EquipmentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository
        extends JpaRepository<EquipmentData, Long>, JpaSpecificationExecutor<EquipmentData> {
    List<EquipmentData> findByFarmerId(Long farmerId);

    Long countByDistrict(String district);

    @Query("SELECT e.district AS district, COUNT(e) AS count FROM EquipmentData e WHERE e.district IS NOT NULL GROUP BY e.district")
    List<DistrictCount> countByDistrictGrouped();
}
