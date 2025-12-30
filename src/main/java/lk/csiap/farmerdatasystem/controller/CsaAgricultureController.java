package lk.csiap.farmerdatasystem.controller;

import jakarta.validation.Valid;
import lk.csiap.farmerdatasystem.dto.ApiResponse;
import lk.csiap.farmerdatasystem.entity.CsaAgricultureData;
import lk.csiap.farmerdatasystem.entity.CsaAgricultureSearch;
import lk.csiap.farmerdatasystem.service.CsaAgricultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/csa-agriculture")
public class CsaAgricultureController {

    @Autowired
    private CsaAgricultureService csaAgricultureService;

    @PostMapping("/search")
    public ResponseEntity<ApiResponse<CsaAgricultureSearch>> getAllCsaAgricultureData(
            @RequestBody(required = false) CsaAgricultureData filter,
            @RequestParam int page,
            @RequestParam int pageSize) {
        CsaAgricultureSearch csaAgricultureSearch = csaAgricultureService.getAllCsaAgricultureData(filter, page,
                pageSize);
        return ResponseEntity
                .ok(ApiResponse.success("CSA Agriculture data retrieved successfully", csaAgricultureSearch));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CsaAgricultureData>> getCsaAgricultureDataById(@PathVariable Long id) {
        CsaAgricultureData data = csaAgricultureService.getCsaAgricultureDataById(id);
        return ResponseEntity.ok(ApiResponse.success("CSA Agriculture data retrieved successfully", data));
    }

    @GetMapping("/farmer/{farmerId}")
    public ResponseEntity<ApiResponse<List<CsaAgricultureData>>> getCsaAgricultureDataByFarmerId(
            @PathVariable Long farmerId) {
        List<CsaAgricultureData> data = csaAgricultureService.getCsaAgricultureDataByFarmerId(farmerId);
        return ResponseEntity.ok(ApiResponse.success("CSA Agriculture data retrieved successfully", data));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CsaAgricultureData>> createCsaAgricultureData(
            @Valid @RequestBody CsaAgricultureData data) {
        CsaAgricultureData createdData = csaAgricultureService.createCsaAgricultureData(data);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("CSA Agriculture data created successfully", createdData));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CsaAgricultureData>> updateCsaAgricultureData(
            @PathVariable Long id,
            @Valid @RequestBody CsaAgricultureData data) {
        CsaAgricultureData updatedData = csaAgricultureService.updateCsaAgricultureData(id, data);
        return ResponseEntity.ok(ApiResponse.success("CSA Agriculture data updated successfully", updatedData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCsaAgricultureData(@PathVariable Long id) {
        csaAgricultureService.deleteCsaAgricultureData(id);
        return ResponseEntity.ok(ApiResponse.success("CSA Agriculture data deleted successfully", null));
    }
}
