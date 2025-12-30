package lk.csiap.farmerdatasystem.controller;

import jakarta.validation.Valid;
import lk.csiap.farmerdatasystem.dto.ApiResponse;
import lk.csiap.farmerdatasystem.entity.PoultryFarmingData;
import lk.csiap.farmerdatasystem.entity.PoultryFarmingSearch;
import lk.csiap.farmerdatasystem.service.PoultryFarmingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/poultry-farming")
public class PoultryFarmingController {

    @Autowired
    private PoultryFarmingService poultryFarmingService;

    @PostMapping("/search")
    public ResponseEntity<ApiResponse<PoultryFarmingSearch>> getAllPoultryFarmingData(
            @RequestBody(required = false) PoultryFarmingData filter,
            @RequestParam int page,
            @RequestParam int pageSize) {
        PoultryFarmingSearch poultryFarmingSearch = poultryFarmingService.getAllPoultryFarmingData(filter, page,
                pageSize);
        return ResponseEntity
                .ok(ApiResponse.success("Poultry Farming data retrieved successfully", poultryFarmingSearch));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PoultryFarmingData>> getPoultryFarmingDataById(@PathVariable Long id) {
        PoultryFarmingData data = poultryFarmingService.getPoultryFarmingDataById(id);
        return ResponseEntity.ok(ApiResponse.success("Poultry Farming data retrieved successfully", data));
    }

    @GetMapping("/farmer/{farmerId}")
    public ResponseEntity<ApiResponse<List<PoultryFarmingData>>> getPoultryFarmingDataByFarmerId(
            @PathVariable Long farmerId) {
        List<PoultryFarmingData> data = poultryFarmingService.getPoultryFarmingDataByFarmerId(farmerId);
        return ResponseEntity.ok(ApiResponse.success("Poultry Farming data retrieved successfully", data));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<PoultryFarmingData>> createPoultryFarmingData(
            @Valid @RequestBody PoultryFarmingData data) {
        PoultryFarmingData createdData = poultryFarmingService.createPoultryFarmingData(data);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Poultry Farming data created successfully", createdData));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<PoultryFarmingData>> updatePoultryFarmingData(
            @PathVariable Long id,
            @Valid @RequestBody PoultryFarmingData data) {
        PoultryFarmingData updatedData = poultryFarmingService.updatePoultryFarmingData(id, data);
        return ResponseEntity.ok(ApiResponse.success("Poultry Farming data updated successfully", updatedData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePoultryFarmingData(@PathVariable Long id) {
        poultryFarmingService.deletePoultryFarmingData(id);
        return ResponseEntity.ok(ApiResponse.success("Poultry Farming data deleted successfully", null));
    }
}
