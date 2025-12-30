package lk.csiap.farmerdatasystem.repository;

import lk.csiap.farmerdatasystem.entity.CsaAgricultureData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CsaAgricultureRepository
        extends JpaRepository<CsaAgricultureData, Long>, JpaSpecificationExecutor<CsaAgricultureData> {
    List<CsaAgricultureData> findByFarmer_FarmerId(Long farmerId);

    @Query("SELECT COALESCE(SUM(c.yieldKg), 0) FROM CsaAgricultureData c WHERE c.yieldKg IS NOT NULL")
    Double sumTotalYield();
}
