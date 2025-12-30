package lk.csiap.farmerdatasystem.service;

import lk.csiap.farmerdatasystem.dto.DashboardSummary;
import lk.csiap.farmerdatasystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private FarmerDimRepository farmerRepository;

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

        // Calculate total yield from CSA and Agro Well data
        Double csaYield = csaAgricultureRepository.sumTotalYield();
        Double agroWellYield = agroWellRepository.sumTotalYield();

        summary.setTotalYieldKg(csaYield + agroWellYield);

        return summary;
    }
}
