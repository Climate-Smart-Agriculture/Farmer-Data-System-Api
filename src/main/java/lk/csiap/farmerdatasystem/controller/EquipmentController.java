package lk.csiap.farmerdatasystem.controller;

import jakarta.validation.Valid;
import lk.csiap.farmerdatasystem.dto.ApiResponse;
import lk.csiap.farmerdatasystem.entity.EquipmentData;
import lk.csiap.farmerdatasystem.entity.EquipmentSearch;
import lk.csiap.farmerdatasystem.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @PostMapping("/search")
    public ResponseEntity<ApiResponse<EquipmentSearch>> getAllEquipmentData(
            @RequestBody(required = false) EquipmentData filter,
            @RequestParam int page,
            @RequestParam int pageSize) {
        EquipmentSearch equipmentSearch = equipmentService.getAllEquipmentData(filter, page, pageSize);
        return ResponseEntity.ok(ApiResponse.success("Equipment data retrieved successfully", equipmentSearch));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EquipmentData>> getEquipmentDataById(@PathVariable Long id) {
        EquipmentData data = equipmentService.getEquipmentDataById(id);
        return ResponseEntity.ok(ApiResponse.success("Equipment data retrieved successfully", data));
    }

    @GetMapping("/farmer/{farmerId}")
    public ResponseEntity<ApiResponse<List<EquipmentData>>> getEquipmentDataByFarmerId(@PathVariable Long farmerId) {
        List<EquipmentData> data = equipmentService.getEquipmentDataByFarmerId(farmerId);
        return ResponseEntity.ok(ApiResponse.success("Equipment data retrieved successfully", data));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<EquipmentData>> createEquipmentData(
            @Valid @RequestBody EquipmentData data) {
        EquipmentData createdData = equipmentService.createEquipmentData(data);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Equipment data created successfully", createdData));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<EquipmentData>> updateEquipmentData(
            @PathVariable Long id,
            @Valid @RequestBody EquipmentData data) {
        EquipmentData updatedData = equipmentService.updateEquipmentData(id, data);
        return ResponseEntity.ok(ApiResponse.success("Equipment data updated successfully", updatedData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteEquipmentData(@PathVariable Long id) {
        equipmentService.deleteEquipmentData(id);
        return ResponseEntity.ok(ApiResponse.success("Equipment data deleted successfully", null));
    }
}
