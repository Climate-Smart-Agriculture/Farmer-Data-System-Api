package lk.csiap.farmerdatasystem.repository;

import lk.csiap.farmerdatasystem.entity.PoultryFarmingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoultryRepository
        extends JpaRepository<PoultryFarmingData, Long>, JpaSpecificationExecutor<PoultryFarmingData> {
    List<PoultryFarmingData> findByFarmerId(Long farmerId);
}
