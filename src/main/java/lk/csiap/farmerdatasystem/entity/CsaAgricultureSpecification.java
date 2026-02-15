package lk.csiap.farmerdatasystem.entity;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;

public class CsaAgricultureSpecification {

    public static Specification<CsaAgricultureData> filter(CsaAgricultureData filter) {
        return (root, query, cb) -> {
            var predicates = new ArrayList<Predicate>();

            // Record ID filter
            if (filter.getRecordId() != null && filter.getRecordId() != 0) {
                predicates.add(cb.equal(root.get("recordId"), filter.getRecordId()));
            }

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
            if (filter.getFarmerId() != null) {
                predicates.add(cb.equal(root.get("farmerId"), filter.getFarmerId()));
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

            if (filter.getProvinceCode() != null && !filter.getProvinceCode().isEmpty()) {
                predicates.add(cb.equal(root.get("provinceCode"), filter.getProvinceCode()));
            }

            // Crop type filters
            if (filter.getCropType() != null && !filter.getCropType().isEmpty()) {
                predicates.add(cb.equal(root.get("cropType"), filter.getCropType()));
            }

            if (filter.getVarietyName() != null && !filter.getVarietyName().isEmpty()) {
                predicates.add(cb.equal(root.get("varietyName"), filter.getVarietyName()));
            }

            if (filter.getIsReplicatedCrop() != null) {
                predicates.add(cb.equal(root.get("isReplicatedCrop"), filter.getIsReplicatedCrop()));
            }

            // Crop growing indicators
            if (filter.getGrownIrrigatedPaddyIndicator() != null) {
                predicates.add(
                        cb.equal(root.get("grownIrrigatedPaddyIndicator"), filter.getGrownIrrigatedPaddyIndicator()));
            }

            if (filter.getGrownRainfedPaddyIndicator() != null) {
                predicates
                        .add(cb.equal(root.get("grownRainfedPaddyIndicator"), filter.getGrownRainfedPaddyIndicator()));
            }

            if (filter.getGrownIrrigatedHighlandIndicator() != null) {
                predicates.add(cb.equal(root.get("grownIrrigatedHighlandIndicator"),
                        filter.getGrownIrrigatedHighlandIndicator()));
            }

            if (filter.getGrownRainfedHighlandIndicator() != null) {
                predicates.add(
                        cb.equal(root.get("grownRainfedHighlandIndicator"), filter.getGrownRainfedHighlandIndicator()));
            }

            // CSA practice filters
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

            // Training filters
            if (filter.getFtsTraining() != null) {
                predicates.add(cb.equal(root.get("ftsTraining"), filter.getFtsTraining()));
            }

            if (filter.getFbsTraining() != null) {
                predicates.add(cb.equal(root.get("fbsTraining"), filter.getFbsTraining()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
