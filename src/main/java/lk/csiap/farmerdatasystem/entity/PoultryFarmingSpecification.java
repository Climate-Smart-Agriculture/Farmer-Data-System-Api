package lk.csiap.farmerdatasystem.entity;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;

public class PoultryFarmingSpecification {

    public static Specification<PoultryFarmingData> filter(PoultryFarmingData filter) {
        return (root, query, cb) -> {
            var predicates = new ArrayList<Predicate>();

            // Year filter
            if (filter.getYear() != null) {
                predicates.add(cb.equal(root.get("year"), filter.getYear()));
            }
            if (filter.getFarmerId() != null) {
                predicates.add(cb.equal(root.get("farmerId"), filter.getFarmerId()));
            }
            // String filters with exact match
            if (filter.getProgramName() != null && !filter.getProgramName().isEmpty()) {
                predicates.add(cb.equal(root.get("programName"), filter.getProgramName()));
            }

            if (filter.getDistrict() != null && !filter.getDistrict().isEmpty()) {
                predicates.add(cb.equal(root.get("district"), filter.getDistrict()));
            }

            if (filter.getDsdDivision() != null && !filter.getDsdDivision().isEmpty()) {
                predicates.add(cb.equal(root.get("dsdDivision"), filter.getDsdDivision()));
            }

            if (filter.getAscDivision() != null && !filter.getAscDivision().isEmpty()) {
                predicates.add(cb.equal(root.get("ascDivision"), filter.getAscDivision()));
            }

            if (filter.getCascadeName() != null && !filter.getCascadeName().isEmpty()) {
                predicates.add(cb.equal(root.get("cascadeName"), filter.getCascadeName()));
            }

            if (filter.getTankOrVisName() != null && !filter.getTankOrVisName().isEmpty()) {
                predicates.add(cb.equal(root.get("tankOrVisName"), filter.getTankOrVisName()));
            }

            if (filter.getProducerSociety() != null && !filter.getProducerSociety().isEmpty()) {
                predicates.add(cb.equal(root.get("producerSociety"), filter.getProducerSociety()));
            }

            if (filter.getAgriculturalInstructor() != null && !filter.getAgriculturalInstructor().isEmpty()) {
                predicates.add(cb.equal(root.get("agriculturalInstructor"), filter.getAgriculturalInstructor()));
            }

            if (filter.getGramaNiladhariDivision() != null && !filter.getGramaNiladhariDivision().isEmpty()) {
                predicates.add(cb.equal(root.get("gramaNiladhariDivision"), filter.getGramaNiladhariDivision()));
            }


            if (filter.getProvinceCode() != null && !filter.getProvinceCode().isEmpty()) {
                predicates.add(cb.equal(root.get("provinceCode"), filter.getProvinceCode()));
            }

            
           
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
