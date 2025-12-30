package lk.csiap.farmerdatasystem.controller;

import jakarta.validation.Valid;
import lk.csiap.farmerdatasystem.dto.ApiResponse;
import lk.csiap.farmerdatasystem.entity.AgroWellData;
import lk.csiap.farmerdatasystem.entity.AgroWellSearch;
import lk.csiap.farmerdatasystem.service.AgroWellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agro-well")
public class AgroWellController {

    @Autowired
    private AgroWellService agroWellService;

    @PostMapping("/search")
    public ResponseEntity<ApiResponse<AgroWellSearch>> getAllAgroWellData(
            @RequestBody(required = false) AgroWellData filter,
            @RequestParam int page,
            @RequestParam int pageSize) {
        AgroWellSearch agroWellSearch = agroWellService.getAllAgroWellData(filter, page, pageSize);
        return ResponseEntity.ok(ApiResponse.success("Agro Well data retrieved successfully", agroWellSearch));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AgroWellData>> getAgroWellDataById(@PathVariable Long id) {
        AgroWellData data = agroWellService.getAgroWellDataById(id);
        return ResponseEntity.ok(ApiResponse.success("Agro Well data retrieved successfully", data));
    }

    @GetMapping("/farmer/{farmerId}")
    public ResponseEntity<ApiResponse<List<AgroWellData>>> getAgroWellDataByFarmerId(@PathVariable Long farmerId) {
        List<AgroWellData> data = agroWellService.getAgroWellDataByFarmerId(farmerId);
        return ResponseEntity.ok(ApiResponse.success("Agro Well data retrieved successfully", data));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AgroWellData>> createAgroWellData(
            @Valid @RequestBody AgroWellData data) {
        AgroWellData createdData = agroWellService.createAgroWellData(data);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Agro Well data created successfully", createdData));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<AgroWellData>> updateAgroWellData(
            @PathVariable Long id,
            @Valid @RequestBody AgroWellData data) {
        AgroWellData updatedData = agroWellService.updateAgroWellData(id, data);
        return ResponseEntity.ok(ApiResponse.success("Agro Well data updated successfully", updatedData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteAgroWellData(@PathVariable Long id) {
        agroWellService.deleteAgroWellData(id);
        return ResponseEntity.ok(ApiResponse.success("Agro Well data deleted successfully", null));
    }
}
