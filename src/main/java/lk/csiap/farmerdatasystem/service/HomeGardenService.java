package lk.csiap.farmerdatasystem.service;

import lk.csiap.farmerdatasystem.entity.HomeGardenData;
import lk.csiap.farmerdatasystem.entity.HomeGardenSearch;
import lk.csiap.farmerdatasystem.entity.HomeGardenSpecification;
import lk.csiap.farmerdatasystem.repository.HomeGardenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeGardenService {

    @Autowired
    private HomeGardenRepository homeGardenRepository;

    public HomeGardenSearch getAllHomeGardenData(HomeGardenData filter, int page, int pageSize) {
        Specification<HomeGardenData> spec = HomeGardenSpecification.filter(filter);
        Pageable pageable = PageRequest.of(page, pageSize);
        int count = (int) homeGardenRepository.count(spec);
        List<HomeGardenData> data = homeGardenRepository.findAll(spec, pageable).getContent();
        return new HomeGardenSearch(count, data);
    }

    public HomeGardenData getHomeGardenDataById(Long id) {
        return homeGardenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Home Garden Data not found with id: " + id));
    }

    public List<HomeGardenData> getHomeGardenDataByFarmerId(Long farmerId) {
        return homeGardenRepository.findByFarmerId(farmerId);
    }

    public HomeGardenData createHomeGardenData(HomeGardenData data) {
        return homeGardenRepository.save(data);
    }

    public HomeGardenData updateHomeGardenData(Long id, HomeGardenData dataDetails) {
        HomeGardenData existingData = getHomeGardenDataById(id);

        existingData.setYear(dataDetails.getYear());
        existingData.setProgramName(dataDetails.getProgramName());
        existingData.setDistrict(dataDetails.getDistrict());
        existingData.setDsdDivision(dataDetails.getDsdDivision());
        existingData.setAscDivision(dataDetails.getAscDivision());
        existingData.setCascadeName(dataDetails.getCascadeName());
        existingData.setTankOrVisName(dataDetails.getTankOrVisName());
        existingData.setProducerSociety(dataDetails.getProducerSociety());
        existingData.setAiRange(dataDetails.getAiRange());
        existingData.setGramaNiladhariDivision(dataDetails.getGramaNiladhariDivision());
        existingData.setVillageName(dataDetails.getVillageName());
        existingData.setFarmerName(dataDetails.getFarmerName());
        existingData.setAddress(dataDetails.getAddress());
        existingData.setNicNumber(dataDetails.getNicNumber());
        existingData.setTelephoneNumber(dataDetails.getTelephoneNumber());
        existingData.setIsFemale(dataDetails.getIsFemale());
        existingData.setIsMale(dataDetails.getIsMale());
        existingData.setIsSamurdhiBeneficiary(dataDetails.getIsSamurdhiBeneficiary());
        existingData.setIsWomanHeadedHousehold(dataDetails.getIsWomanHeadedHousehold());
        existingData.setIsDisabled(dataDetails.getIsDisabled());
        existingData.setIsCsaConducted(dataDetails.getIsCsaConducted());
        existingData.setIsIecConducted(dataDetails.getIsIecConducted());
        existingData.setExtentHa(dataDetails.getExtentHa());
        existingData.setSeedPackCount(dataDetails.getSeedPackCount());
        existingData.setBananaPlantsCount(dataDetails.getBananaPlantsCount());
        existingData.setPapayaPlantsCount(dataDetails.getPapayaPlantsCount());
        existingData.setPassionfruitPlantsCount(dataDetails.getPassionfruitPlantsCount());
        existingData.setLemonPlantsCount(dataDetails.getLemonPlantsCount());
        existingData.setCompostBags25kgCount(dataDetails.getCompostBags25kgCount());
        existingData.setGrowBagsCount(dataDetails.getGrowBagsCount());
        existingData.setTotalProjectCostRs(dataDetails.getTotalProjectCostRs());
        existingData.setVegetableProductionKg(dataDetails.getVegetableProductionKg());
        existingData.setHomeConsumptionKg(dataDetails.getHomeConsumptionKg());
        existingData.setShareWithNeighborsKg(dataDetails.getShareWithNeighborsKg());
        existingData.setSoldQuantityKg(dataDetails.getSoldQuantityKg());
        existingData.setSoldPriceRs(dataDetails.getSoldPriceRs());
        existingData.setIncomeRs(dataDetails.getIncomeRs());
        existingData.setMangoCount(dataDetails.getMangoCount());
        existingData.setOrangeCount(dataDetails.getOrangeCount());
        existingData.setHandSpadeCount(dataDetails.getHandSpadeCount());
        existingData.setHandForkCount(dataDetails.getHandForkCount());
        existingData.setSecateursCount(dataDetails.getSecateursCount());
        existingData.setPvcTank500mlCount(dataDetails.getPvcTank500mlCount());
        existingData.setWateringCanCount(dataDetails.getWateringCanCount());
        existingData.setMulchingMatCount(dataDetails.getMulchingMatCount());
        existingData.setNurseryTraysCount(dataDetails.getNurseryTraysCount());
        existingData.setBlackPolytheneCount(dataDetails.getBlackPolytheneCount());
        existingData.setGrossIncomeRs(dataDetails.getGrossIncomeRs());
        existingData.setNewCultivation1(dataDetails.getNewCultivation1());
        existingData.setNewCultivation2(dataDetails.getNewCultivation2());
        existingData.setNewCultivation3(dataDetails.getNewCultivation3());
        existingData.setNewCultivation4(dataDetails.getNewCultivation4());
        existingData.setNewCultivation5(dataDetails.getNewCultivation5());
        existingData.setNewCultivation6(dataDetails.getNewCultivation6());
        existingData.setNewCultivation7(dataDetails.getNewCultivation7());
        existingData.setNewCultivation8(dataDetails.getNewCultivation8());
        existingData.setNewCultivation9(dataDetails.getNewCultivation9());
        existingData.setNewCultivation10(dataDetails.getNewCultivation10());
        existingData.setNewCultivation11(dataDetails.getNewCultivation11());
        existingData.setNewCultivation12(dataDetails.getNewCultivation12());
        existingData.setNewCultivation13(dataDetails.getNewCultivation13());
        existingData.setNewCultivation14(dataDetails.getNewCultivation14());
        existingData.setNewCultivation15(dataDetails.getNewCultivation15());

        return homeGardenRepository.save(existingData);
    }

    public void deleteHomeGardenData(Long id) {
        HomeGardenData data = getHomeGardenDataById(id);
        homeGardenRepository.delete(data);
    }
}
