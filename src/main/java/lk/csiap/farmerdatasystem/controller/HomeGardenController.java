package lk.csiap.farmerdatasystem.controller;

import jakarta.validation.Valid;
import lk.csiap.farmerdatasystem.dto.ApiResponse;
import lk.csiap.farmerdatasystem.entity.HomeGardenData;
import lk.csiap.farmerdatasystem.entity.HomeGardenSearch;
import lk.csiap.farmerdatasystem.service.HomeGardenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home-garden")
public class HomeGardenController {

    @Autowired
    private HomeGardenService homeGardenService;

    @PostMapping("/search")
    public ResponseEntity<ApiResponse<HomeGardenSearch>> getAllHomeGardenData(
            @RequestBody(required = false) HomeGardenData filter,
            @RequestParam int page,
            @RequestParam int pageSize) {
        HomeGardenSearch homeGardenSearch = homeGardenService.getAllHomeGardenData(filter, page, pageSize);
        //Print first record for debugging
        if (homeGardenSearch.getHomeGardenData() != null && !homeGardenSearch.getHomeGardenData().isEmpty()) {
            System.out.println("First record: " + homeGardenSearch.getHomeGardenData().get(0));
        } else {
            System.out.println("No records found.");
        }
        return ResponseEntity.ok(ApiResponse.success("Home Garden data retrieved successfully", homeGardenSearch));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<HomeGardenData>> getHomeGardenDataById(@PathVariable Long id) {
        HomeGardenData data = homeGardenService.getHomeGardenDataById(id);
        return ResponseEntity.ok(ApiResponse.success("Home Garden data retrieved successfully", data));
    }

    @GetMapping("/farmer/{farmerId}")
    public ResponseEntity<ApiResponse<List<HomeGardenData>>> getHomeGardenDataByFarmerId(@PathVariable Long farmerId) {
        List<HomeGardenData> data = homeGardenService.getHomeGardenDataByFarmerId(farmerId);
        return ResponseEntity.ok(ApiResponse.success("Home Garden data retrieved successfully", data));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<HomeGardenData>> createHomeGardenData(
            @Valid @RequestBody HomeGardenData data) {
        HomeGardenData createdData = homeGardenService.createHomeGardenData(data);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Home Garden data created successfully", createdData));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<HomeGardenData>> updateHomeGardenData(
            @PathVariable Long id,
            @Valid @RequestBody HomeGardenData data) {
        HomeGardenData updatedData = homeGardenService.updateHomeGardenData(id, data);
        return ResponseEntity.ok(ApiResponse.success("Home Garden data updated successfully", updatedData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteHomeGardenData(@PathVariable Long id) {
        homeGardenService.deleteHomeGardenData(id);
        return ResponseEntity.ok(ApiResponse.success("Home Garden data deleted successfully", null));
    }
}
