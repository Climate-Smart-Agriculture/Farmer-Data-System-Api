package lk.csiap.farmerdatasystem.entity;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;

public class AgroWellSpecification {

    public static Specification<AgroWellData> filter(AgroWellData filter) {
        return (root, query, cb) -> {
            var predicates = new ArrayList<Predicate>();

            // String filters with exact match
            if (filter.getRecordId() != null && filter.getRecordId() != 0) {
                predicates.add(cb.equal(root.get("recordId"), filter.getRecordId()));
            }
            if (filter.getFarmerId() != null) {
                predicates.add(cb.equal(root.get("farmerId"), filter.getFarmerId()));
            }
            if (filter.getYear() != null) {
                predicates.add(cb.equal(root.get("year"), filter.getYear()));
            }
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

            if (filter.getFarmerOrganizationName() != null && !filter.getFarmerOrganizationName().isEmpty()) {
                predicates.add(cb.equal(root.get("farmerOrganizationName"), filter.getFarmerOrganizationName()));
            }

            if (filter.getAiRange() != null && !filter.getAiRange().isEmpty()) {
                predicates.add(cb.equal(root.get("aiRange"), filter.getAiRange()));
            }

            if (filter.getGramaNiladhariDivision() != null && !filter.getGramaNiladhariDivision().isEmpty()) {
                predicates.add(cb.equal(root.get("gramaNiladhariDivision"), filter.getGramaNiladhariDivision()));
            }

            if (filter.getVillageName() != null && !filter.getVillageName().isEmpty()) {
                predicates.add(cb.equal(root.get("villageName"), filter.getVillageName()));
            }

            if (filter.getCultivations() != null && !filter.getCultivations().isEmpty()) {
                predicates.add(cb.equal(root.get("cultivations"), filter.getCultivations()));
            }

            if (filter.getIrrigationMethod() != null && !filter.getIrrigationMethod().isEmpty()) {
                predicates.add(cb.equal(root.get("irrigationMethod"), filter.getIrrigationMethod()));
            }

            if (filter.getProvinceCode() != null && !filter.getProvinceCode().isEmpty()) {
                predicates.add(cb.equal(root.get("provinceCode"), filter.getProvinceCode()));
            }

            // Integer indicator filters
            if (filter.getIsReplicatedCrop() != null) {
                predicates.add(cb.equal(root.get("isReplicatedCrop"), filter.getIsReplicatedCrop()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
