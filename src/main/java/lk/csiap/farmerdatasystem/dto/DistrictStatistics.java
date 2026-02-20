package lk.csiap.farmerdatasystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistrictStatistics {
    private String district;
    private Long farmerCount;
    private Long equipmentCount;
    private Long homeGardenCount;
    private Long csaAgricultureCount;
    private Long agroWellCount;
    private Long poultryFarmCount;
    private Double totalYieldKg;
    private Double totalIncomeRs;
}
