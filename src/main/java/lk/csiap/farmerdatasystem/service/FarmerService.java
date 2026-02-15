package lk.csiap.farmerdatasystem.service;

import lk.csiap.farmerdatasystem.entity.FarmerDim;
import lk.csiap.farmerdatasystem.entity.FarmerDimSearch;
import lk.csiap.farmerdatasystem.repository.FarmerDimRepository;
import lk.csiap.farmerdatasystem.entity.FarmerDimSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class FarmerService {

    @Autowired
    private FarmerDimRepository farmerRepository;
    // Return farmer list and total count

    public FarmerDimSearch getAllFarmers(FarmerDim filter, int page, int pageSize) {

        Specification<FarmerDim> spec = FarmerDimSpecification.filter(filter);

        Pageable pageable = PageRequest.of(page, pageSize);
        int count = (int) farmerRepository.count(spec);
        List<FarmerDim> farmers = farmerRepository.findAll(spec, pageable).getContent();
        return new FarmerDimSearch(count, farmers);
    }

    public FarmerDim getFarmerById(Long id) {
        return farmerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Farmer not found with id: " + id));
    }

    public FarmerDim getFarmerByNic(String nic) {
        return farmerRepository.findByNicNumber(nic)
                .orElseThrow(() -> new RuntimeException("Farmer not found with NIC: " + nic));
    }

    public FarmerDim createFarmer(FarmerDim farmer) {
        if (farmerRepository.existsByNicNumber(farmer.getNicNumber())) {
            throw new RuntimeException("Farmer with NIC already exists");
        }
        return farmerRepository.save(farmer);
    }

    public FarmerDim updateFarmer(Long id, FarmerDim farmerDetails) {
        FarmerDim farmer = getFarmerById(id);

        farmer.setFarmerName(farmerDetails.getFarmerName());
        farmer.setNicNumber(farmerDetails.getNicNumber());
        farmer.setAddress(farmerDetails.getAddress());
        farmer.setDistrict(farmerDetails.getDistrict());
        farmer.setVillageName(farmerDetails.getVillageName());
        farmer.setDsdDivision(farmerDetails.getDsdDivision());
        farmer.setAscDivision(farmerDetails.getAscDivision());
        farmer.setAiRange(farmerDetails.getAiRange());
        farmer.setGramaNiladhariDivision(farmerDetails.getGramaNiladhariDivision());
        farmer.setCascadeName(farmerDetails.getCascadeName());
        farmer.setTankOrVisName(farmerDetails.getTankOrVisName());
        farmer.setProducerSociety(farmerDetails.getProducerSociety());
        farmer.setFarmerOrganizationName(farmerDetails.getFarmerOrganizationName());
        farmer.setCommandAreaHa(farmerDetails.getCommandAreaHa());
        farmer.setTelephoneNumber(farmerDetails.getTelephoneNumber());
        farmer.setGender(farmerDetails.getGender());
        farmer.setIsSamurdhiBeneficiary(farmerDetails.getIsSamurdhiBeneficiary());
        farmer.setIsWomanHeadedHousehold(farmerDetails.getIsWomanHeadedHousehold());
        farmer.setIsDisabled(farmerDetails.getIsDisabled());
        farmer.setIsCsaConducted(farmerDetails.getIsCsaConducted());
        farmer.setIsIecConducted(farmerDetails.getIsIecConducted());
        farmer.setFtsTraining(farmerDetails.getFtsTraining());
        farmer.setFbsTraining(farmerDetails.getFbsTraining());
        farmer.setCsaCropDiversification(farmerDetails.getCsaCropDiversification());
        farmer.setCsaSeedProduction(farmerDetails.getCsaSeedProduction());
        farmer.setCsaInterseason(farmerDetails.getCsaInterseason());
        farmer.setCsaMicroIrrigation(farmerDetails.getCsaMicroIrrigation());
        farmer.setCsaHomeGardening(farmerDetails.getCsaHomeGardening());
        farmer.setCsaAgronomicInterventions(farmerDetails.getCsaAgronomicInterventions());
        farmer.setProvinceCode(farmerDetails.getProvinceCode());
        return farmerRepository.save(farmer);
    }

    public void deleteFarmer(Long id) {
        FarmerDim farmer = getFarmerById(id);
        farmerRepository.delete(farmer);
    }
}
