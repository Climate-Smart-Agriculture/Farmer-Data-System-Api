package lk.csiap.farmerdatasystem.service;

import lk.csiap.farmerdatasystem.entity.FarmerDim;
import lk.csiap.farmerdatasystem.repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FarmerService {

    @Autowired
    private FarmerRepository farmerRepository;

    public List<FarmerDim> getAllFarmers() {
        return farmerRepository.findAll();
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
