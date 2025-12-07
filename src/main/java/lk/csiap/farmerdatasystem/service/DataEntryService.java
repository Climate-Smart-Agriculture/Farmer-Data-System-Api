package lk.csiap.farmerdatasystem.service;

import lk.csiap.farmerdatasystem.entity.*;
import lk.csiap.farmerdatasystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataEntryService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private HomeGardenRepository homeGardenRepository;

    @Autowired
    private CsaAgricultureRepository csaAgricultureRepository;

    @Autowired
    private AgroWellRepository agroWellRepository;

    @Autowired
    private PoultryRepository poultryRepository;

    @Autowired
    private FarmerRepository farmerRepository;

    // Equipment methods
    public List<EquipmentData> getAllEquipmentByFarmerId(Long farmerId) {
        return equipmentRepository.findByFarmer_FarmerId(farmerId);
    }

    public EquipmentData createEquipment(Long farmerId, EquipmentData equipment) {
        FarmerDim farmer = farmerRepository.findById(farmerId)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));
        equipment.setFarmer(farmer);
        return equipmentRepository.save(equipment);
    }

    public EquipmentData updateEquipment(Long id, EquipmentData equipmentDetails) {
        EquipmentData equipment = equipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipment not found"));
        
        equipment.setEquipmentType(equipmentDetails.getEquipmentType());
        equipment.setEquipmentName(equipmentDetails.getEquipmentName());
        equipment.setBrand(equipmentDetails.getBrand());
        equipment.setModel(equipmentDetails.getModel());
        equipment.setPurchaseDate(equipmentDetails.getPurchaseDate());
        equipment.setPurchasePrice(equipmentDetails.getPurchasePrice());
        equipment.setConditionStatus(equipmentDetails.getConditionStatus());
        equipment.setNotes(equipmentDetails.getNotes());

        return equipmentRepository.save(equipment);
    }

    public void deleteEquipment(Long id) {
        equipmentRepository.deleteById(id);
    }

    // Home Garden methods
    public List<HomeGardenData> getAllHomeGardensByFarmerId(Long farmerId) {
        return homeGardenRepository.findByFarmer_FarmerId(farmerId);
    }

    public HomeGardenData createHomeGarden(Long farmerId, HomeGardenData homeGarden) {
        FarmerDim farmer = farmerRepository.findById(farmerId)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));
        homeGarden.setFarmer(farmer);
        return homeGardenRepository.save(homeGarden);
    }

    public HomeGardenData updateHomeGarden(Long id, HomeGardenData homeGardenDetails) {
        HomeGardenData homeGarden = homeGardenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Home garden not found"));
        
        homeGarden.setCropType(homeGardenDetails.getCropType());
        homeGarden.setCropVariety(homeGardenDetails.getCropVariety());
        homeGarden.setCultivationAreaSqm(homeGardenDetails.getCultivationAreaSqm());
        homeGarden.setPlantingDate(homeGardenDetails.getPlantingDate());
        homeGarden.setExpectedHarvestDate(homeGardenDetails.getExpectedHarvestDate());
        homeGarden.setActualHarvestDate(homeGardenDetails.getActualHarvestDate());
        homeGarden.setYieldKg(homeGardenDetails.getYieldKg());
        homeGarden.setIrrigationMethod(homeGardenDetails.getIrrigationMethod());
        homeGarden.setFertilizerUsed(homeGardenDetails.getFertilizerUsed());
        homeGarden.setPesticideUsed(homeGardenDetails.getPesticideUsed());
        homeGarden.setNotes(homeGardenDetails.getNotes());

        return homeGardenRepository.save(homeGarden);
    }

    public void deleteHomeGarden(Long id) {
        homeGardenRepository.deleteById(id);
    }

    // CSA Agriculture methods
    public List<CsaAgricultureData> getAllCsaAgricultureByFarmerId(Long farmerId) {
        return csaAgricultureRepository.findByFarmer_FarmerId(farmerId);
    }

    public CsaAgricultureData createCsaAgriculture(Long farmerId, CsaAgricultureData csaAgriculture) {
        FarmerDim farmer = farmerRepository.findById(farmerId)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));
        csaAgriculture.setFarmer(farmer);
        return csaAgricultureRepository.save(csaAgriculture);
    }

    public CsaAgricultureData updateCsaAgriculture(Long id, CsaAgricultureData csaDetails) {
        CsaAgricultureData csa = csaAgricultureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CSA agriculture not found"));
        
        csa.setCropType(csaDetails.getCropType());
        csa.setCropVariety(csaDetails.getCropVariety());
        csa.setCultivationAreaHectares(csaDetails.getCultivationAreaHectares());
        csa.setSeason(csaDetails.getSeason());
        csa.setPlantingDate(csaDetails.getPlantingDate());
        csa.setExpectedHarvestDate(csaDetails.getExpectedHarvestDate());
        csa.setActualHarvestDate(csaDetails.getActualHarvestDate());
        csa.setYieldKg(csaDetails.getYieldKg());
        csa.setIrrigationType(csaDetails.getIrrigationType());
        csa.setWaterSource(csaDetails.getWaterSource());
        csa.setClimateSmartPractices(csaDetails.getClimateSmartPractices());
        csa.setFertilizerType(csaDetails.getFertilizerType());
        csa.setPesticideType(csaDetails.getPesticideType());
        csa.setProductionCost(csaDetails.getProductionCost());
        csa.setMarketPricePerKg(csaDetails.getMarketPricePerKg());
        csa.setNotes(csaDetails.getNotes());

        return csaAgricultureRepository.save(csa);
    }

    public void deleteCsaAgriculture(Long id) {
        csaAgricultureRepository.deleteById(id);
    }

    // Agro Well methods
    public List<AgroWellAgricultureData> getAllAgroWellsByFarmerId(Long farmerId) {
        return agroWellRepository.findByFarmer_FarmerId(farmerId);
    }

    public AgroWellAgricultureData createAgroWell(Long farmerId, AgroWellAgricultureData agroWell) {
        FarmerDim farmer = farmerRepository.findById(farmerId)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));
        agroWell.setFarmer(farmer);
        return agroWellRepository.save(agroWell);
    }

    public AgroWellAgricultureData updateAgroWell(Long id, AgroWellAgricultureData agroWellDetails) {
        AgroWellAgricultureData agroWell = agroWellRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agro well not found"));
        
        agroWell.setWellNumber(agroWellDetails.getWellNumber());
        agroWell.setWellDepthMeters(agroWellDetails.getWellDepthMeters());
        agroWell.setWaterCapacityCubicMeters(agroWellDetails.getWaterCapacityCubicMeters());
        agroWell.setPumpType(agroWellDetails.getPumpType());
        agroWell.setPumpPowerHp(agroWellDetails.getPumpPowerHp());
        agroWell.setIrrigatedAreaHectares(agroWellDetails.getIrrigatedAreaHectares());
        agroWell.setCropType(agroWellDetails.getCropType());
        agroWell.setCropVariety(agroWellDetails.getCropVariety());
        agroWell.setPlantingDate(agroWellDetails.getPlantingDate());
        agroWell.setExpectedHarvestDate(agroWellDetails.getExpectedHarvestDate());
        agroWell.setActualHarvestDate(agroWellDetails.getActualHarvestDate());
        agroWell.setYieldKg(agroWellDetails.getYieldKg());
        agroWell.setWaterUsageHoursPerDay(agroWellDetails.getWaterUsageHoursPerDay());
        agroWell.setElectricityCost(agroWellDetails.getElectricityCost());
        agroWell.setMaintenanceCost(agroWellDetails.getMaintenanceCost());
        agroWell.setNotes(agroWellDetails.getNotes());

        return agroWellRepository.save(agroWell);
    }

    public void deleteAgroWell(Long id) {
        agroWellRepository.deleteById(id);
    }

    // Poultry methods
    public List<PoultryFarmingData> getAllPoultryByFarmerId(Long farmerId) {
        return poultryRepository.findByFarmer_FarmerId(farmerId);
    }

    public PoultryFarmingData createPoultry(Long farmerId, PoultryFarmingData poultry) {
        FarmerDim farmer = farmerRepository.findById(farmerId)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));
        poultry.setFarmer(farmer);
        return poultryRepository.save(poultry);
    }

    public PoultryFarmingData updatePoultry(Long id, PoultryFarmingData poultryDetails) {
        PoultryFarmingData poultry = poultryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Poultry farming not found"));
        
        poultry.setPoultryType(poultryDetails.getPoultryType());
        poultry.setBreed(poultryDetails.getBreed());
        poultry.setBirdCount(poultryDetails.getBirdCount());
        poultry.setBatchDate(poultryDetails.getBatchDate());
        poultry.setHousingType(poultryDetails.getHousingType());
        poultry.setFeedingMethod(poultryDetails.getFeedingMethod());
        poultry.setFeedCostPerMonth(poultryDetails.getFeedCostPerMonth());
        poultry.setEggProductionPerDay(poultryDetails.getEggProductionPerDay());
        poultry.setMeatProductionKg(poultryDetails.getMeatProductionKg());
        poultry.setMortalityCount(poultryDetails.getMortalityCount());
        poultry.setVaccinationStatus(poultryDetails.getVaccinationStatus());
        poultry.setHealthIssues(poultryDetails.getHealthIssues());
        poultry.setRevenuePerMonth(poultryDetails.getRevenuePerMonth());
        poultry.setNotes(poultryDetails.getNotes());

        return poultryRepository.save(poultry);
    }

    public void deletePoultry(Long id) {
        poultryRepository.deleteById(id);
    }
}
