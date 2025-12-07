package lk.csiap.farmerdatasystem.repository;

import lk.csiap.farmerdatasystem.entity.AgroWellAgricultureData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgroWellRepository extends JpaRepository<AgroWellAgricultureData, Long> {
    List<AgroWellAgricultureData> findByFarmer_FarmerId(Long farmerId);
    
    @Query("SELECT COALESCE(SUM(a.yieldKg), 0) FROM AgroWellAgricultureData a WHERE a.yieldKg IS NOT NULL")
    Double sumTotalYield();
}
