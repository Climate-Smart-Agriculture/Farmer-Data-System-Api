package lk.csiap.farmerdatasystem.entity;

import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;

public class FarmerDimSpecification {

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

            if (filter.getIsDisabled() != null) {
            predicates.add(cb.equal(root.get("isDisabled"), filter.getIsDisabled()));
            }

            if (filter.getIsSamurdhiBeneficiary() != null) {
            predicates.add(cb.equal(root.get("isSamurdhiBeneficiary"),
            filter.getIsSamurdhiBeneficiary()));
            }

            if (filter.getIsWomanHeadedHousehold() != null) {
                predicates.add(cb.equal(root.get("isWomanHeadedHousehold"),
                        filter.getIsWomanHeadedHousehold()));
            }

            if (filter.getNic() != null && !filter.getNic().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("nic")),
                        "%" + filter.getNic().toLowerCase() + "%"));
            }

            if (filter.getContactNumber() != null && !filter.getContactNumber().isEmpty()) {
                predicates.add(cb.like(root.get("contactNumber"),
                        "%" + filter.getContactNumber() + "%"));
            }

            if (filter.getEmail() != null && !filter.getEmail().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("email")),
                        "%" + filter.getEmail().toLowerCase() + "%"));
            }

            if (filter.getAddress() != null && !filter.getAddress().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("address")),
                        "%" + filter.getAddress().toLowerCase() + "%"));
            }

            if (filter.getVillageName() != null && !filter.getVillageName().isEmpty()) {
                predicates.add(cb.equal(root.get("villageName"), filter.getVillageName()));
            }
            if (filter.getFarmerId() != null) {
                predicates.add(cb.equal(root.get("farmerId"), filter.getFarmerId()));
            }
            if (filter.getDsdDivision() != null && !filter.getDsdDivision().isEmpty()) {
                predicates.add(cb.equal(root.get("dsdDivision"), filter.getDsdDivision()));
            }

            if (filter.getAscDivision() != null && !filter.getAscDivision().isEmpty()) {
                predicates.add(cb.equal(root.get("ascDivision"), filter.getAscDivision()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}