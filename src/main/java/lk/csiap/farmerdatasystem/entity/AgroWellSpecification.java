package lk.csiap.farmerdatasystem.entity;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;

public class AgroWellSpecification {

    public static Specification<AgroWellData> filter(AgroWellData filter) {
        return (root, query, cb) -> {
            var predicates = new ArrayList<Predicate>();

            // String filters with exact match
            if (filter.getProgramName() != null && !filter.getProgramName().isEmpty()) {
                predicates.add(cb.equal(root.get("programName"), filter.getProgramName()));
            }
            if (filter.getFarmerId() != null) {
                predicates.add(cb.equal(root.get("farmerId"), filter.getFarmerId()));
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

            if (filter.getIsReplicatedCrop() != null) {
                predicates.add(cb.equal(root.get("isReplicatedCrop"), filter.getIsReplicatedCrop()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
