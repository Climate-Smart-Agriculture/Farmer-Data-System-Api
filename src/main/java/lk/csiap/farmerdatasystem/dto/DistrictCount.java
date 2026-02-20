package lk.csiap.farmerdatasystem.dto;

/**
 * Simple projection interface for district-level count queries.
 */
public interface DistrictCount {
    String getDistrict();
    Long getCount();
}
