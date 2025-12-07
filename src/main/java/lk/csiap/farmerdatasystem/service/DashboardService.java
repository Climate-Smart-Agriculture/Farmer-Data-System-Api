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
        
        // Calculate total land area
        Double totalLandArea = farmerRepository.findAll().stream()
                .filter(f -> f.getLandSizeHectares() != null)
                .mapToDouble(f -> f.getLandSizeHectares())
                .sum();
        summary.setTotalLandArea(totalLandArea);
        
        // Calculate total yield from all sources
        Double homeGardenYield = homeGardenRepository.findAll().stream()
                .filter(h -> h.getYieldKg() != null)
                .mapToDouble(h -> h.getYieldKg())
                .sum();
        
        Double csaYield = csaAgricultureRepository.findAll().stream()
                .filter(c -> c.getYieldKg() != null)
                .mapToDouble(c -> c.getYieldKg())
                .sum();
        
        Double agroWellYield = agroWellRepository.findAll().stream()
                .filter(a -> a.getYieldKg() != null)
                .mapToDouble(a -> a.getYieldKg())
                .sum();
        
        summary.setTotalYieldKg(homeGardenYield + csaYield + agroWellYield);
        
        return summary;
    }
}
