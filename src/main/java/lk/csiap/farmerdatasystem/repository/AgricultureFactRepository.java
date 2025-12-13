package lk.csiap.farmerdatasystem.repository;

import lk.csiap.farmerdatasystem.entity.AgricultureFact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgricultureFactRepository extends JpaRepository<AgricultureFact, Long> {

}