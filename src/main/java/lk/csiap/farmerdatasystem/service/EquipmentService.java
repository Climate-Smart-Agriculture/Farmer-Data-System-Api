package lk.csiap.farmerdatasystem.service;

import lk.csiap.farmerdatasystem.entity.EquipmentData;
import lk.csiap.farmerdatasystem.entity.EquipmentSearch;
import lk.csiap.farmerdatasystem.entity.EquipmentSpecification;
import lk.csiap.farmerdatasystem.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    public EquipmentSearch getAllEquipmentData(EquipmentData filter, int page, int pageSize) {
        Specification<EquipmentData> spec = EquipmentSpecification.filter(filter);
        Pageable pageable = PageRequest.of(page, pageSize);
        int count = (int) equipmentRepository.count(spec);
        List<EquipmentData> data = equipmentRepository.findAll(spec, pageable).getContent();
        return new EquipmentSearch(count, data);
    }

    public EquipmentData getEquipmentDataById(Long id) {
        return equipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipment Data not found with id: " + id));
    }

    public List<EquipmentData> getEquipmentDataByFarmerId(Long farmerId) {
        return equipmentRepository.findByFarmer_FarmerId(farmerId);
    }

    public EquipmentData createEquipmentData(EquipmentData data) {
        return equipmentRepository.save(data);
    }

    public EquipmentData updateEquipmentData(Long id, EquipmentData dataDetails) {
        EquipmentData existingData = getEquipmentDataById(id);

        existingData.setYear(dataDetails.getYear());
        existingData.setProgramName(dataDetails.getProgramName());
        existingData.setDistrict(dataDetails.getDistrict());
        existingData.setDsdDivision(dataDetails.getDsdDivision());
        existingData.setAscDivision(dataDetails.getAscDivision());
        existingData.setCascadeName(dataDetails.getCascadeName());
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
        existingData.setEquipmentName(dataDetails.getEquipmentName());
        existingData.setIsReplicated(dataDetails.getIsReplicated());
        existingData.setNoOfEquipment(dataDetails.getNoOfEquipment());
        existingData.setExtentHa(dataDetails.getExtentHa());
        existingData.setStepApprovalNumber(dataDetails.getStepApprovalNumber());
        existingData.setUnitPriceRs(dataDetails.getUnitPriceRs());
        existingData.setTotalProjectCostRs(dataDetails.getTotalProjectCostRs());
        existingData.setFarmerCostRs(dataDetails.getFarmerCostRs());
        existingData.setProvinceCode(dataDetails.getProvinceCode());

        return equipmentRepository.save(existingData);
    }

    public void deleteEquipmentData(Long id) {
        EquipmentData data = getEquipmentDataById(id);
        equipmentRepository.delete(data);
    }
}
