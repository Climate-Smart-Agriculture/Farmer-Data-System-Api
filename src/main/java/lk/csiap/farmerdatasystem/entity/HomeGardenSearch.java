package lk.csiap.farmerdatasystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeGardenSearch {
    int totalCount;
    List<HomeGardenData> homeGardenData;
}
