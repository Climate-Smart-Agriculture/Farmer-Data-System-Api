package lk.csiap.farmerdatasystem.service;

import lk.csiap.farmerdatasystem.entity.CsaAgricultureData;
import lk.csiap.farmerdatasystem.entity.CsaAgricultureSearch;
import lk.csiap.farmerdatasystem.entity.CsaAgricultureSpecification;
import lk.csiap.farmerdatasystem.repository.CsaAgricultureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CsaAgricultureService {

    @Autowired
    private CsaAgricultureRepository csaAgricultureRepository;

    public CsaAgricultureSearch getAllCsaAgricultureData(CsaAgricultureData filter, int page, int pageSize) {
        Specification<CsaAgricultureData> spec = CsaAgricultureSpecification.filter(filter);
        Pageable pageable = PageRequest.of(page, pageSize);
        int count = (int) csaAgricultureRepository.count(spec);
        List<CsaAgricultureData> data = csaAgricultureRepository.findAll(spec, pageable).getContent();
        return new CsaAgricultureSearch(count, data);
    }

    public CsaAgricultureData getCsaAgricultureDataById(Long id) {
        return csaAgricultureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CSA Agriculture Data not found with id: " + id));
    }

    public List<CsaAgricultureData> getCsaAgricultureDataByFarmerId(Long farmerId) {
        return csaAgricultureRepository.findByFarmerId(farmerId);
    }

    public CsaAgricultureData createCsaAgricultureData(CsaAgricultureData data) {
        return csaAgricultureRepository.save(data);
    }

    public CsaAgricultureData updateCsaAgricultureData(Long id, CsaAgricultureData dataDetails) {
        CsaAgricultureData existingData = getCsaAgricultureDataById(id);

        existingData.setYear(dataDetails.getYear());
        existingData.setProgramName(dataDetails.getProgramName());
        existingData.setDistrict(dataDetails.getDistrict());
        existingData.setDsdDivision(dataDetails.getDsdDivision());
        existingData.setAscDivision(dataDetails.getAscDivision());
        existingData.setCascadeName(dataDetails.getCascadeName());
        existingData.setTankOrVisName(dataDetails.getTankOrVisName());
        existingData.setCommandAreaHa(dataDetails.getCommandAreaHa());
        existingData.setProducerSociety(dataDetails.getProducerSociety());
        existingData.setFarmerOrganizationName(dataDetails.getFarmerOrganizationName());
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
        existingData.setCropType(dataDetails.getCropType());
        existingData.setIsReplicatedCrop(dataDetails.getIsReplicatedCrop());
        existingData.setGrownIrrigatedPaddyIndicator(dataDetails.getGrownIrrigatedPaddyIndicator());
        existingData.setGrownRainfedPaddyIndicator(dataDetails.getGrownRainfedPaddyIndicator());
        existingData.setGrownIrrigatedHighlandIndicator(dataDetails.getGrownIrrigatedHighlandIndicator());
        existingData.setGrownRainfedHighlandIndicator(dataDetails.getGrownRainfedHighlandIndicator());
        existingData.setCsaCropDiversification(dataDetails.getCsaCropDiversification());
        existingData.setCsaSeedProduction(dataDetails.getCsaSeedProduction());
        existingData.setCsaInterseason(dataDetails.getCsaInterseason());
        existingData.setCsaMicroIrrigation(dataDetails.getCsaMicroIrrigation());
        existingData.setCsaHomeGardening(dataDetails.getCsaHomeGardening());
        existingData.setCsaAgronomicInterventions(dataDetails.getCsaAgronomicInterventions());
        existingData.setCsaTrainingReceived(dataDetails.getCsaTrainingReceived());
        existingData.setIecConducted(dataDetails.getIecConducted());
        existingData.setFtsTraining(dataDetails.getFtsTraining());
        existingData.setFbsTraining(dataDetails.getFbsTraining());
        existingData.setVarietyName(dataDetails.getVarietyName());
        existingData.setSeedQuantityKg(dataDetails.getSeedQuantityKg());
        existingData.setExtentHa(dataDetails.getExtentHa());
        existingData.setPreLossesHa(dataDetails.getPreLossesHa());
        existingData.setHarvestedAreaHa(dataDetails.getHarvestedAreaHa());
        existingData.setSeedUnitPriceRs(dataDetails.getSeedUnitPriceRs());
        existingData.setProjectSeedExpenseRs(dataDetails.getProjectSeedExpenseRs());
        existingData.setFarmerContributionSeedRs(dataDetails.getFarmerContributionSeedRs());
        existingData.setTotalSeedCostRs(dataDetails.getTotalSeedCostRs());
        existingData.setFarmerCostRs(dataDetails.getFarmerCostRs());
        existingData.setTotalCultivationCostRs(dataDetails.getTotalCultivationCostRs());
        existingData.setPostLossesKg(dataDetails.getPostLossesKg());
        existingData.setYieldKg(dataDetails.getYieldKg());
        existingData.setSoldUnitPriceRs(dataDetails.getSoldUnitPriceRs());
        existingData.setIncomeRs(dataDetails.getIncomeRs());
        existingData.setNetIncomeRs(dataDetails.getNetIncomeRs());
        existingData.setProductivityKgPerHa(dataDetails.getProductivityKgPerHa());
        existingData.setBaselineProductivityKgPerHa(dataDetails.getBaselineProductivityKgPerHa());
        existingData.setYieldIncreaseMt(dataDetails.getYieldIncreaseMt());
        existingData.setYieldIncreasePercent(dataDetails.getYieldIncreasePercent());
        existingData.setBaselinePriceRsPerKg(dataDetails.getBaselinePriceRsPerKg());
        existingData.setBaselineValuePerHaRs(dataDetails.getBaselineValuePerHaRs());
        existingData.setProductivityValuePerHaRs(dataDetails.getProductivityValuePerHaRs());
        existingData.setIncrementalProductivityValueRs(dataDetails.getIncrementalProductivityValueRs());
        existingData.setCdiScore(dataDetails.getCdiScore());
        existingData.setCroppingIntensityPercent(dataDetails.getCroppingIntensityPercent());
        existingData.setProvinceCode(dataDetails.getProvinceCode());

        return csaAgricultureRepository.save(existingData);
    }

    public void deleteCsaAgricultureData(Long id) {
        CsaAgricultureData data = getCsaAgricultureDataById(id);
        csaAgricultureRepository.delete(data);
    }
}
