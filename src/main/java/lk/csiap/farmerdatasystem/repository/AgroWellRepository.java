package lk.csiap.farmerdatasystem.repository;

import lk.csiap.farmerdatasystem.entity.AgroWellData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgroWellRepository extends JpaRepository<AgroWellData, Long>, JpaSpecificationExecutor<AgroWellData> {
    List<AgroWellData> findByFarmerId(Long farmerId);

    @Query("SELECT COALESCE(SUM(a.yieldKg), 0) FROM AgroWellData a WHERE a.yieldKg IS NOT NULL")
    Double sumTotalYield();
}
