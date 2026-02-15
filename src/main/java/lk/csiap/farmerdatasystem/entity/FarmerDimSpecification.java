package lk.csiap.farmerdatasystem.entity;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;

public class FarmerDimSpecification {

    public static Specification<FarmerDim> filter(FarmerDim filter) {
        return (root, query, cb) -> {
            var predicates = new ArrayList<Predicate>();

            if (filter.getFarmerName() != null && !filter.getFarmerName().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("farmerName")),
                        "%" + filter.getFarmerName().toLowerCase() + "%"));
            }

            if (filter.getNicNumber() != null && !filter.getNicNumber().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("nicNumber")),
                        "%" + filter.getNicNumber().toLowerCase() + "%"));
            }

            if (filter.getTelephoneNumber() != null && !filter.getTelephoneNumber().isEmpty()) {
                predicates.add(cb.like(root.get("telephoneNumber"),
                        "%" + filter.getTelephoneNumber() + "%"));
            }

            if (filter.getAddress() != null && !filter.getAddress().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("address")),
                        "%" + filter.getAddress().toLowerCase() + "%"));
            }

            if (filter.getDistrict() != null && !filter.getDistrict().isEmpty()) {
                predicates.add(cb.equal(root.get("district"), filter.getDistrict()));
            }

            if (filter.getVillageName() != null && !filter.getVillageName().isEmpty()) {
                predicates.add(cb.equal(root.get("villageName"), filter.getVillageName()));
            }

            if (filter.getDsdDivision() != null && !filter.getDsdDivision().isEmpty()) {
                predicates.add(cb.equal(root.get("dsdDivision"), filter.getDsdDivision()));
            }

            if (filter.getAscDivision() != null && !filter.getAscDivision().isEmpty()) {
                predicates.add(cb.equal(root.get("ascDivision"), filter.getAscDivision()));
            }

            if (filter.getAiRange() != null && !filter.getAiRange().isEmpty()) {
                predicates.add(cb.equal(root.get("aiRange"), filter.getAiRange()));
            }

            if (filter.getGramaNiladhariDivision() != null && !filter.getGramaNiladhariDivision().isEmpty()) {
                predicates.add(cb.equal(root.get("gramaNiladhariDivision"), filter.getGramaNiladhariDivision()));
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

            if (filter.getGender() != null && !filter.getGender().isEmpty()) {
                predicates.add(cb.equal(root.get("gender"), filter.getGender()));
            }

            if (filter.getProvinceCode() != null && !filter.getProvinceCode().isEmpty()) {
                predicates.add(cb.equal(root.get("provinceCode"), filter.getProvinceCode()));
            }

            if (filter.getIsDisabled() != null) {
                predicates.add(cb.equal(root.get("isDisabled"), filter.getIsDisabled()));
            }

            if (filter.getIsWomanHeadedHousehold() != null) {
                predicates.add(cb.equal(root.get("isWomanHeadedHousehold"),
                        filter.getIsWomanHeadedHousehold()));
            }

            if (filter.getIsSamurdhiBeneficiary() != null) {
                predicates.add(cb.equal(root.get("isSamurdhiBeneficiary"),
                        filter.getIsSamurdhiBeneficiary()));
            }

            if (filter.getIsCsaConducted() != null) {
                predicates.add(cb.equal(root.get("isCsaConducted"), filter.getIsCsaConducted()));
            }

            if (filter.getIsIecConducted() != null) {
                predicates.add(cb.equal(root.get("isIecConducted"), filter.getIsIecConducted()));
            }

            if (filter.getFtsTraining() != null) {
                predicates.add(cb.equal(root.get("ftsTraining"), filter.getFtsTraining()));
            }

            if (filter.getFbsTraining() != null) {
                predicates.add(cb.equal(root.get("fbsTraining"), filter.getFbsTraining()));
            }

            if (filter.getCsaCropDiversification() != null) {
                predicates.add(cb.equal(root.get("csaCropDiversification"), filter.getCsaCropDiversification()));
            }

            if (filter.getCsaSeedProduction() != null) {
                predicates.add(cb.equal(root.get("csaSeedProduction"), filter.getCsaSeedProduction()));
            }

            if (filter.getCsaInterseason() != null) {
                predicates.add(cb.equal(root.get("csaInterseason"), filter.getCsaInterseason()));
            }

            if (filter.getCsaMicroIrrigation() != null) {
                predicates.add(cb.equal(root.get("csaMicroIrrigation"), filter.getCsaMicroIrrigation()));
            }

            if (filter.getCsaHomeGardening() != null) {
                predicates.add(cb.equal(root.get("csaHomeGardening"), filter.getCsaHomeGardening()));
            }

            if (filter.getCsaAgronomicInterventions() != null) {
                predicates.add(cb.equal(root.get("csaAgronomicInterventions"), filter.getCsaAgronomicInterventions()));
            }

            if (filter.getFarmerId() != null) {
                predicates.add(cb.equal(root.get("farmerId"), filter.getFarmerId()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}