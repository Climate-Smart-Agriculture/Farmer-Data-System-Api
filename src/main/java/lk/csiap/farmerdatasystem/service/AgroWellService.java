package lk.csiap.farmerdatasystem.service;

import lk.csiap.farmerdatasystem.entity.AgroWellData;
import lk.csiap.farmerdatasystem.entity.AgroWellSearch;
import lk.csiap.farmerdatasystem.entity.AgroWellSpecification;
import lk.csiap.farmerdatasystem.repository.AgroWellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgroWellService {

    @Autowired
    private AgroWellRepository agroWellRepository;

    public AgroWellSearch getAllAgroWellData(AgroWellData filter, int page, int pageSize) {
        Specification<AgroWellData> spec = AgroWellSpecification.filter(filter);
        Pageable pageable = PageRequest.of(page, pageSize);
        int count = (int) agroWellRepository.count(spec);
        List<AgroWellData> data = agroWellRepository.findAll(spec, pageable).getContent();
        return new AgroWellSearch(count, data);
    }

    public AgroWellData getAgroWellDataById(Long id) {
        return agroWellRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agro Well Data not found with id: " + id));
    }

    public List<AgroWellData> getAgroWellDataByFarmerId(Long farmerId) {
        return agroWellRepository.findByFarmerId(farmerId);
    }

    public AgroWellData createAgroWellData(AgroWellData data) {
        return agroWellRepository.save(data);
    }

    public AgroWellData updateAgroWellData(Long id, AgroWellData dataDetails) {
        AgroWellData existingData = getAgroWellDataById(id);

        existingData.setRecordId(dataDetails.getRecordId());
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
        existingData.setCultivations(dataDetails.getCultivations());
        existingData.setIsReplicatedCrop(dataDetails.getIsReplicatedCrop());
        existingData.setExtentHa(dataDetails.getExtentHa());
        existingData.setNoOfPlant(dataDetails.getNoOfPlant());
        existingData.setTotalCultivationCostRs(dataDetails.getTotalCultivationCostRs());
        existingData.setAgrowellDepreciationPerSeasonCostRs(dataDetails.getAgrowellDepreciationPerSeasonCostRs());
        existingData.setTotalCostRs(dataDetails.getTotalCostRs());
        existingData.setYieldKg(dataDetails.getYieldKg());
        existingData.setIncomeRs(dataDetails.getIncomeRs());
        existingData.setNetIncomeRs(dataDetails.getNetIncomeRs());
        existingData.setIrrigationMethod(dataDetails.getIrrigationMethod());
        existingData.setProvinceCode(dataDetails.getProvinceCode());

        return agroWellRepository.save(existingData);
    }

    public void deleteAgroWellData(Long id) {
        AgroWellData data = getAgroWellDataById(id);
        agroWellRepository.delete(data);
    }
}
