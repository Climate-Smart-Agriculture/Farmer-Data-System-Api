package lk.csiap.farmerdatasystem.repository;

import lk.csiap.farmerdatasystem.entity.CsaAgricultureData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CsaAgricultureRepository extends JpaRepository<CsaAgricultureData, Long> {
    List<CsaAgricultureData> findByFarmer_FarmerId(Long farmerId);
}
