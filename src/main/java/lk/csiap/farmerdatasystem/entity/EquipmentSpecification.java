package lk.csiap.farmerdatasystem.entity;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;

public class EquipmentSpecification {

    public static Specification<EquipmentData> filter(EquipmentData filter) {
        return (root, query, cb) -> {
            var predicates = new ArrayList<Predicate>();

            // Record ID filter
            if (filter.getRecordId() != null && !filter.getRecordId().toString().isEmpty()) {
                predicates.add(cb.equal(root.get("recordId"), filter.getRecordId()));
            }

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

            // Equipment name filter
            if (filter.getEquipmentName() != null && !filter.getEquipmentName().isEmpty()) {
                predicates.add(cb.equal(root.get("equipmentName"), filter.getEquipmentName()));
            }

            // Equipment name standard filter
            if (filter.getEquipmentNameStandard() != null && !filter.getEquipmentNameStandard().isEmpty()) {
                predicates.add(cb.equal(root.get("equipmentNameStandard"), filter.getEquipmentNameStandard()));
            }

            // Descriptive extent filter
            if (filter.getDescriptiveExtentHa() != null && !filter.getDescriptiveExtentHa().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("descriptiveExtentHa")),
                        "%" + filter.getDescriptiveExtentHa().toLowerCase() + "%"));
            }

            // Descriptive unit price filter
            if (filter.getDescriptiveUnitPriceRs() != null && !filter.getDescriptiveUnitPriceRs().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("descriptiveUnitPriceRs")),
                        "%" + filter.getDescriptiveUnitPriceRs().toLowerCase() + "%"));
            }

            // Descriptive farmer cost filter
            if (filter.getDescriptiveFarmerCostRs() != null && !filter.getDescriptiveFarmerCostRs().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("descriptiveFarmerCostRs")),
                        "%" + filter.getDescriptiveFarmerCostRs().toLowerCase() + "%"));
            }

            // Integer indicator filters
            if (filter.getIsReplicated() != null) {
                predicates.add(cb.equal(root.get("isReplicated"), filter.getIsReplicated()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
