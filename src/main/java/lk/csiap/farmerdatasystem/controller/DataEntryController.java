package lk.csiap.farmerdatasystem.controller;

import jakarta.validation.Valid;
import lk.csiap.farmerdatasystem.dto.ApiResponse;
import lk.csiap.farmerdatasystem.entity.*;
import lk.csiap.farmerdatasystem.service.DataEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data-entry")
// Global CORS configuration is in SecurityConfig.java
// @CrossOrigin(origins = "*")
public class DataEntryController {

    @Autowired
    private DataEntryService dataEntryService;

    // Equipment endpoints
    @GetMapping("/equipment/farmer/{farmerId}")
    public ResponseEntity<ApiResponse<List<EquipmentData>>> getEquipmentByFarmer(@PathVariable Long farmerId) {
        List<EquipmentData> equipment = dataEntryService.getAllEquipmentByFarmerId(farmerId);
        return ResponseEntity.ok(ApiResponse.success("Equipment retrieved successfully", equipment));
    }

    @PostMapping("/equipment/farmer/{farmerId}")
    public ResponseEntity<ApiResponse<EquipmentData>> createEquipment(
            @PathVariable Long farmerId,
            @Valid @RequestBody EquipmentData equipment) {
        EquipmentData created = dataEntryService.createEquipment(farmerId, equipment);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Equipment created successfully", created));
    }

    @PutMapping("/equipment/{id}")
    public ResponseEntity<ApiResponse<EquipmentData>> updateEquipment(
            @PathVariable Long id,
            @Valid @RequestBody EquipmentData equipment) {
        EquipmentData updated = dataEntryService.updateEquipment(id, equipment);
        return ResponseEntity.ok(ApiResponse.success("Equipment updated successfully", updated));
    }

    @DeleteMapping("/equipment/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteEquipment(@PathVariable Long id) {
        dataEntryService.deleteEquipment(id);
        return ResponseEntity.ok(ApiResponse.success("Equipment deleted successfully", null));
    }

    // Home Garden endpoints
    @GetMapping("/home-garden/farmer/{farmerId}")
    public ResponseEntity<ApiResponse<List<HomeGardenData>>> getHomeGardensByFarmer(@PathVariable Long farmerId) {
        List<HomeGardenData> gardens = dataEntryService.getAllHomeGardensByFarmerId(farmerId);
        return ResponseEntity.ok(ApiResponse.success("Home gardens retrieved successfully", gardens));
    }

    @PostMapping("/home-garden/farmer/{farmerId}")
    public ResponseEntity<ApiResponse<HomeGardenData>> createHomeGarden(
            @PathVariable Long farmerId,
            @Valid @RequestBody HomeGardenData homeGarden) {
        HomeGardenData created = dataEntryService.createHomeGarden(farmerId, homeGarden);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Home garden created successfully", created));
    }

    @PutMapping("/home-garden/{id}")
    public ResponseEntity<ApiResponse<HomeGardenData>> updateHomeGarden(
            @PathVariable Long id,
            @Valid @RequestBody HomeGardenData homeGarden) {
        HomeGardenData updated = dataEntryService.updateHomeGarden(id, homeGarden);
        return ResponseEntity.ok(ApiResponse.success("Home garden updated successfully", updated));
    }

    @DeleteMapping("/home-garden/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteHomeGarden(@PathVariable Long id) {
        dataEntryService.deleteHomeGarden(id);
        return ResponseEntity.ok(ApiResponse.success("Home garden deleted successfully", null));
    }

    // CSA Agriculture endpoints
    @GetMapping("/csa-agriculture/farmer/{farmerId}")
    public ResponseEntity<ApiResponse<List<CsaAgricultureData>>> getCsaAgricultureByFarmer(@PathVariable Long farmerId) {
        List<CsaAgricultureData> data = dataEntryService.getAllCsaAgricultureByFarmerId(farmerId);
        return ResponseEntity.ok(ApiResponse.success("CSA agriculture data retrieved successfully", data));
    }

    @PostMapping("/csa-agriculture/farmer/{farmerId}")
    public ResponseEntity<ApiResponse<CsaAgricultureData>> createCsaAgriculture(
            @PathVariable Long farmerId,
            @Valid @RequestBody CsaAgricultureData csaAgriculture) {
        CsaAgricultureData created = dataEntryService.createCsaAgriculture(farmerId, csaAgriculture);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("CSA agriculture created successfully", created));
    }

    @PutMapping("/csa-agriculture/{id}")
    public ResponseEntity<ApiResponse<CsaAgricultureData>> updateCsaAgriculture(
            @PathVariable Long id,
            @Valid @RequestBody CsaAgricultureData csaAgriculture) {
        CsaAgricultureData updated = dataEntryService.updateCsaAgriculture(id, csaAgriculture);
        return ResponseEntity.ok(ApiResponse.success("CSA agriculture updated successfully", updated));
    }

    @DeleteMapping("/csa-agriculture/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCsaAgriculture(@PathVariable Long id) {
        dataEntryService.deleteCsaAgriculture(id);
        return ResponseEntity.ok(ApiResponse.success("CSA agriculture deleted successfully", null));
    }

    // Agro Well endpoints
    @GetMapping("/agro-well/farmer/{farmerId}")
    public ResponseEntity<ApiResponse<List<AgroWellAgricultureData>>> getAgroWellsByFarmer(@PathVariable Long farmerId) {
        List<AgroWellAgricultureData> data = dataEntryService.getAllAgroWellsByFarmerId(farmerId);
        return ResponseEntity.ok(ApiResponse.success("Agro well data retrieved successfully", data));
    }

    @PostMapping("/agro-well/farmer/{farmerId}")
    public ResponseEntity<ApiResponse<AgroWellAgricultureData>> createAgroWell(
            @PathVariable Long farmerId,
            @Valid @RequestBody AgroWellAgricultureData agroWell) {
        AgroWellAgricultureData created = dataEntryService.createAgroWell(farmerId, agroWell);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Agro well created successfully", created));
    }

    @PutMapping("/agro-well/{id}")
    public ResponseEntity<ApiResponse<AgroWellAgricultureData>> updateAgroWell(
            @PathVariable Long id,
            @Valid @RequestBody AgroWellAgricultureData agroWell) {
        AgroWellAgricultureData updated = dataEntryService.updateAgroWell(id, agroWell);
        return ResponseEntity.ok(ApiResponse.success("Agro well updated successfully", updated));
    }

    @DeleteMapping("/agro-well/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteAgroWell(@PathVariable Long id) {
        dataEntryService.deleteAgroWell(id);
        return ResponseEntity.ok(ApiResponse.success("Agro well deleted successfully", null));
    }

    // Poultry endpoints
    @GetMapping("/poultry/farmer/{farmerId}")
    public ResponseEntity<ApiResponse<List<PoultryFarmingData>>> getPoultryByFarmer(@PathVariable Long farmerId) {
        List<PoultryFarmingData> data = dataEntryService.getAllPoultryByFarmerId(farmerId);
        return ResponseEntity.ok(ApiResponse.success("Poultry data retrieved successfully", data));
    }

    @PostMapping("/poultry/farmer/{farmerId}")
    public ResponseEntity<ApiResponse<PoultryFarmingData>> createPoultry(
            @PathVariable Long farmerId,
            @Valid @RequestBody PoultryFarmingData poultry) {
        PoultryFarmingData created = dataEntryService.createPoultry(farmerId, poultry);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Poultry created successfully", created));
    }

    @PutMapping("/poultry/{id}")
    public ResponseEntity<ApiResponse<PoultryFarmingData>> updatePoultry(
            @PathVariable Long id,
            @Valid @RequestBody PoultryFarmingData poultry) {
        PoultryFarmingData updated = dataEntryService.updatePoultry(id, poultry);
        return ResponseEntity.ok(ApiResponse.success("Poultry updated successfully", updated));
    }

    @DeleteMapping("/poultry/{id}")
    public ResponseEntity<ApiResponse<Void>> deletePoultry(@PathVariable Long id) {
        dataEntryService.deletePoultry(id);
        return ResponseEntity.ok(ApiResponse.success("Poultry deleted successfully", null));
    }
}
