package lk.csiap.farmerdatasystem.dto;

/**
 * Simple projection interface for district-level yield/income aggregations.
 */
public interface DistrictYield {
    String getDistrict();
    Double getTotalYield();
    Double getTotalIncome();
}
