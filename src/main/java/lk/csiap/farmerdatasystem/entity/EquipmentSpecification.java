package lk.csiap.farmerdatasystem.entity;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;

public class EquipmentSpecification {

    public static Specification<EquipmentData> filter(EquipmentData filter) {
        return (root, query, cb) -> {
            var predicates = new ArrayList<Predicate>();

            // Year filter
            if (filter.getYear() != null) {
                predicates.add(cb.equal(root.get("year"), filter.getYear()));
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

            if (filter.getProvinceCode() != null && !filter.getProvinceCode().isEmpty()) {
                predicates.add(cb.equal(root.get("provinceCode"), filter.getProvinceCode()));
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

            // Equipment name filter
            if (filter.getEquipmentName() != null && !filter.getEquipmentName().isEmpty()) {
                predicates.add(cb.equal(root.get("equipmentName"), filter.getEquipmentName()));
            }

            // Integer indicator filters
            if (filter.getIsFemale() != null) {
                predicates.add(cb.equal(root.get("isFemale"), filter.getIsFemale()));
            }

            if (filter.getIsMale() != null) {
                predicates.add(cb.equal(root.get("isMale"), filter.getIsMale()));
            }

            if (filter.getIsReplicated() != null) {
                predicates.add(cb.equal(root.get("isReplicated"), filter.getIsReplicated()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
