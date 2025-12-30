package lk.csiap.farmerdatasystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoultryFarmingSearch {
    int totalCount;
    List<PoultryFarmingData> poultryFarmingData;
}
