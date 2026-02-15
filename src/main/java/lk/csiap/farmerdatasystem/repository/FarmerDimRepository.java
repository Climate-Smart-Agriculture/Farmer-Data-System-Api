package lk.csiap.farmerdatasystem.repository;

import lk.csiap.farmerdatasystem.entity.FarmerDim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FarmerDimRepository extends JpaRepository<FarmerDim, Long>,
        JpaSpecificationExecutor<FarmerDim> {
    Optional<FarmerDim> findByNicNumber(String nicNumber);

    Boolean existsByNicNumber(String nicNumber);

}
