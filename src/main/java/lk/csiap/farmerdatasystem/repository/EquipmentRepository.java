package lk.csiap.farmerdatasystem.repository;

import lk.csiap.farmerdatasystem.entity.EquipmentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<EquipmentData, Long> {
    List<EquipmentData> findByFarmer_FarmerId(Long farmerId);
}
