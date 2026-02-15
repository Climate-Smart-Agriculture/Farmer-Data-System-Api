package lk.csiap.farmerdatasystem.service;

import lk.csiap.farmerdatasystem.entity.PoultryFarmingData;
import lk.csiap.farmerdatasystem.entity.PoultryFarmingSearch;
import lk.csiap.farmerdatasystem.entity.PoultryFarmingSpecification;
import lk.csiap.farmerdatasystem.repository.PoultryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoultryFarmingService {

    @Autowired
    private PoultryRepository poultryRepository;

    public PoultryFarmingSearch getAllPoultryFarmingData(PoultryFarmingData filter, int page, int pageSize) {
        Specification<PoultryFarmingData> spec = PoultryFarmingSpecification.filter(filter);
        Pageable pageable = PageRequest.of(page, pageSize);
        int count = (int) poultryRepository.count(spec);
        List<PoultryFarmingData> data = poultryRepository.findAll(spec, pageable).getContent();
        return new PoultryFarmingSearch(count, data);
    }

    public PoultryFarmingData getPoultryFarmingDataById(Long id) {
        return poultryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Poultry Farming Data not found with id: " + id));
    }

    public List<PoultryFarmingData> getPoultryFarmingDataByFarmerId(Long farmerId) {
        return poultryRepository.findByFarmerId(farmerId);
    }

    public PoultryFarmingData createPoultryFarmingData(PoultryFarmingData data) {
        return poultryRepository.save(data);
    }

    public PoultryFarmingData updatePoultryFarmingData(Long id, PoultryFarmingData dataDetails) {
        PoultryFarmingData existingData = getPoultryFarmingDataById(id);

        existingData.setRecordId(dataDetails.getRecordId());
        existingData.setYear(dataDetails.getYear());
        existingData.setProgramName(dataDetails.getProgramName());
        existingData.setDistrict(dataDetails.getDistrict());
        existingData.setDsdDivision(dataDetails.getDsdDivision());
        existingData.setAscDivision(dataDetails.getAscDivision());
        existingData.setCascadeName(dataDetails.getCascadeName());
        existingData.setTankOrVisName(dataDetails.getTankOrVisName());
        existingData.setProducerSociety(dataDetails.getProducerSociety());
        existingData.setAgriculturalInstructor(dataDetails.getAgriculturalInstructor());
        existingData.setGramaNiladhariDivision(dataDetails.getGramaNiladhariDivision());
        existingData.setChicksGiven(dataDetails.getChicksGiven());
        existingData.setChickUnitPriceRs(dataDetails.getChickUnitPriceRs());
        existingData.setTotalProjectCostRs(dataDetails.getTotalProjectCostRs());
        existingData.setFarmerContributionRs(dataDetails.getFarmerContributionRs());
        existingData.setTotalCostRs(dataDetails.getTotalCostRs());
        existingData.setDeadChicks(dataDetails.getDeadChicks());
        existingData.setTotalEggProduction(dataDetails.getTotalEggProduction());
        existingData.setFlockSizeIncrement(dataDetails.getFlockSizeIncrement());
        existingData.setFeedExpenditureRs(dataDetails.getFeedExpenditureRs());
        existingData.setEggUnitPriceRs(dataDetails.getEggUnitPriceRs());
        existingData.setIncomeRs(dataDetails.getIncomeRs());
        existingData.setNetIncomeRs(dataDetails.getNetIncomeRs());
        existingData.setProvinceCode(dataDetails.getProvinceCode());

        return poultryRepository.save(existingData);
    }

    public void deletePoultryFarmingData(Long id) {
        PoultryFarmingData data = getPoultryFarmingDataById(id);
        poultryRepository.delete(data);
    }
}
