package lk.csiap.farmerdatasystem.controller;

import jakarta.validation.Valid;
import lk.csiap.farmerdatasystem.dto.ApiResponse;
import lk.csiap.farmerdatasystem.entity.FarmerDim;
import lk.csiap.farmerdatasystem.entity.FarmerDimSearch;
import lk.csiap.farmerdatasystem.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmers")
// Global CORS configuration is in SecurityConfig.java
// @CrossOrigin(origins = "*")
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    @PostMapping("/search")
    public ResponseEntity<ApiResponse<FarmerDimSearch>> getAllFarmers(@RequestBody(required = false) FarmerDim filter,
            @RequestParam int page, @RequestParam int pageSize) {
        System.out.println("Filter: " + filter.getGender());
        FarmerDimSearch farmerSearch = farmerService.getAllFarmers(filter, page, pageSize);
        return ResponseEntity.ok(ApiResponse.success("Farmers retrieved successfully", farmerSearch));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<FarmerDim>> getFarmerById(@PathVariable Long id) {
        FarmerDim farmer = farmerService.getFarmerById(id);
        return ResponseEntity.ok(ApiResponse.success("Farmer retrieved successfully", farmer));
    }

    @GetMapping("/unique-values/{fieldName}")
    public ResponseEntity<ApiResponse<List<String>>> getUniqueFieldValues(@PathVariable String fieldName) {
        List<String> uniqueValues = null;
        // farmerService.getUniqueFieldValues(fieldName);
        return ResponseEntity.ok(ApiResponse.success("Unique values retrieved successfully", uniqueValues));
    }

    @GetMapping("/nic/{nic}")
    public ResponseEntity<ApiResponse<FarmerDim>> getFarmerByNic(@PathVariable String nic) {
        FarmerDim farmer = farmerService.getFarmerByNic(nic);
        return ResponseEntity.ok(ApiResponse.success("Farmer retrieved successfully", farmer));
    }

    @PostMapping()
    public ResponseEntity<ApiResponse<FarmerDim>> createFarmer(@Valid @RequestBody FarmerDim farmer) {
        FarmerDim createdFarmer = farmerService.createFarmer(farmer);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Farmer created successfully", createdFarmer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<FarmerDim>> updateFarmer(
            @PathVariable Long id,
            @Valid @RequestBody FarmerDim farmer) {
        FarmerDim updatedFarmer = farmerService.updateFarmer(id, farmer);
        return ResponseEntity.ok(ApiResponse.success("Farmer updated successfully", updatedFarmer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteFarmer(@PathVariable Long id) {
        farmerService.deleteFarmer(id);
        return ResponseEntity.ok(ApiResponse.success("Farmer deleted successfully", null));
    }
}
