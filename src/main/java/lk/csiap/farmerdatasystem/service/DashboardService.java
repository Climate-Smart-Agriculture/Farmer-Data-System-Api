package lk.csiap.farmerdatasystem.service;

import lk.csiap.farmerdatasystem.dto.DashboardSummary;
import lk.csiap.farmerdatasystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private FarmerRepository farmerRepository;

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

    public DashboardSummary getDashboardSummary() {
        DashboardSummary summary = new DashboardSummary();
        
        summary.setTotalFarmers(farmerRepository.count());
        summary.setTotalEquipment(equipmentRepository.count());
        summary.setTotalHomeGardens(homeGardenRepository.count());
        summary.setTotalCsaAgriculture(csaAgricultureRepository.count());
        summary.setTotalAgroWells(agroWellRepository.count());
        summary.setTotalPoultryFarms(poultryRepository.count());
        
        // Calculate total land area using database aggregation
        summary.setTotalLandArea(farmerRepository.sumTotalLandArea());
        
        // Calculate total yield from all sources using database aggregation
        Double homeGardenYield = homeGardenRepository.sumTotalYield();
        Double csaYield = csaAgricultureRepository.sumTotalYield();
        Double agroWellYield = agroWellRepository.sumTotalYield();
        
        summary.setTotalYieldKg(homeGardenYield + csaYield + agroWellYield);
        
        return summary;
    }
}
