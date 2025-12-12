package lk.csiap.farmerdatasystem.entity;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;

public class FarmerSpecification {

    public static Specification<FarmerDim> filter(FarmerDim filter) {
        return (root, query, cb) -> {
            var predicates = new ArrayList<Predicate>();

            if (filter.getFullName() != null && !filter.getFullName().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("fullName")),
                        "%" + filter.getFullName().toLowerCase() + "%"));
            }

            if (filter.getDistrict() != null && !filter.getDistrict().isEmpty()) {
                predicates.add(cb.equal(root.get("district"), filter.getDistrict()));
            }

            if (filter.getGender() != null && !filter.getGender().isEmpty()) {
                predicates.add(cb.equal(root.get("gender"), filter.getGender()));
            }

            // if (filter.getIsDisabled() != null) {
            // predicates.add(cb.equal(root.get("isDisabled"), filter.getIsDisabled()));
            // }

            // if (filter.getIsSamurdhiBeneficiary() != null) {
            // predicates.add(cb.equal(root.get("isSamurdhiBeneficiary"),
            // filter.getIsSamurdhiBeneficiary()));
            // }

            // if (filter.getIsWomanHeadedHousehold() != null) {
            // predicates.add(cb.equal(root.get("isWomanHeadedHousehold"),
            // filter.getIsWomanHeadedHousehold()));
            // }

            // Add more filters as needed

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}