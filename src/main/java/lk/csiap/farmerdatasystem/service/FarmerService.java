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
        return farmerRepository.findByNic(nic)
                .orElseThrow(() -> new RuntimeException("Farmer not found with NIC: " + nic));
    }

    public FarmerDim createFarmer(FarmerDim farmer) {
        if (farmerRepository.existsByNic(farmer.getNic())) {
            throw new RuntimeException("Farmer with NIC already exists");
        }
        return farmerRepository.save(farmer);
    }

    public FarmerDim updateFarmer(Long id, FarmerDim farmerDetails) {
        FarmerDim farmer = getFarmerById(id);

        farmer.setFullName(farmerDetails.getFullName());
        farmer.setContactNumber(farmerDetails.getContactNumber());
        farmer.setEmail(farmerDetails.getEmail());
        farmer.setAddress(farmerDetails.getAddress());
        farmer.setDistrict(farmerDetails.getDistrict());
        farmer.setVillageName(farmerDetails.getVillageName());
        farmer.setDsdDivision(farmerDetails.getDsdDivision());
        farmer.setAscDivision(farmerDetails.getAscDivision());
        farmer.setGender(farmerDetails.getGender());
        farmer.setIsSamurdhiBeneficiary(farmerDetails.getIsSamurdhiBeneficiary());
        farmer.setIsDisabled(farmerDetails.getIsDisabled());
        farmer.setIsWomanHeadedHousehold(farmerDetails.getIsWomanHeadedHousehold());
        return farmerRepository.save(farmer);
    }

    public void deleteFarmer(Long id) {
        FarmerDim farmer = getFarmerById(id);
        farmerRepository.delete(farmer);
    }
}
