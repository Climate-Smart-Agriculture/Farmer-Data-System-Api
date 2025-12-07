package lk.csiap.farmerdatasystem.repository;

import lk.csiap.farmerdatasystem.entity.HomeGardenData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeGardenRepository extends JpaRepository<HomeGardenData, Long> {
    List<HomeGardenData> findByFarmer_FarmerId(Long farmerId);
}
