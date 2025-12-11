package lk.csiap.farmerdatasystem.repository;

import lk.csiap.farmerdatasystem.entity.FarmerDim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FarmerRepository extends JpaRepository<FarmerDim, Long> {
    Optional<FarmerDim> findByNic(String nic);

    Boolean existsByNic(String nic);
}
