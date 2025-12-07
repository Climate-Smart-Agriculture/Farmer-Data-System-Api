package lk.csiap.farmerdatasystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardSummary {
    private Long totalFarmers;
    private Long totalEquipment;
    private Long totalHomeGardens;
    private Long totalCsaAgriculture;
    private Long totalAgroWells;
    private Long totalPoultryFarms;
    private Double totalLandArea;
    private Double totalYieldKg;
}
