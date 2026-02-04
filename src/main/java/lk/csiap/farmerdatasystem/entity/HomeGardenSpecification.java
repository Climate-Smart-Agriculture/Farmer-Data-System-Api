package lk.csiap.farmerdatasystem.entity;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;

public class HomeGardenSpecification {

    public static Specification<HomeGardenData> filter(HomeGardenData filter) {
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

            if (filter.getAiRange() != null && !filter.getAiRange().isEmpty()) {
                predicates.add(cb.equal(root.get("aiRange"), filter.getAiRange()));
            }

            if (filter.getGramaNiladhariDivision() != null && !filter.getGramaNiladhariDivision().isEmpty()) {
                predicates.add(cb.equal(root.get("gramaNiladhariDivision"), filter.getGramaNiladhariDivision()));
            }

            if (filter.getVillageName() != null && !filter.getVillageName().isEmpty()) {
                predicates.add(cb.equal(root.get("villageName"), filter.getVillageName()));
            }

            // Partial match filters for farmer info
            if (filter.getFarmerName() != null && !filter.getFarmerName().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("farmerName")),
                        "%" + filter.getFarmerName().toLowerCase() + "%"));
            }

            if (filter.getAddress() != null && !filter.getAddress().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("address")),
                        "%" + filter.getAddress().toLowerCase() + "%"));
            }

            if (filter.getNicNumber() != null && !filter.getNicNumber().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("nicNumber")),
                        "%" + filter.getNicNumber().toLowerCase() + "%"));
            }

            if (filter.getTelephoneNumber() != null && !filter.getTelephoneNumber().isEmpty()) {
                predicates.add(cb.like(root.get("telephoneNumber"),
                        "%" + filter.getTelephoneNumber() + "%"));
            }

            // Integer indicator filters
            if (filter.getIsFemale() != null) {
                predicates.add(cb.equal(root.get("isFemale"), filter.getIsFemale()));
            }

            if (filter.getIsMale() != null) {
                predicates.add(cb.equal(root.get("isMale"), filter.getIsMale()));
            }

            if (filter.getIsSamurdhiBeneficiary() != null) {
                predicates.add(cb.equal(root.get("isSamurdhiBeneficiary"), filter.getIsSamurdhiBeneficiary()));
            }

            if (filter.getIsWomanHeadedHousehold() != null) {
                predicates.add(cb.equal(root.get("isWomanHeadedHousehold"), filter.getIsWomanHeadedHousehold()));
            }

            if (filter.getIsDisabled() != null) {
                predicates.add(cb.equal(root.get("isDisabled"), filter.getIsDisabled()));
            }

            if (filter.getIsCsaConducted() != null) {
                predicates.add(cb.equal(root.get("isCsaConducted"), filter.getIsCsaConducted()));
            }

            if (filter.getIsIecConducted() != null) {
                predicates.add(cb.equal(root.get("isIecConducted"), filter.getIsIecConducted()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
