package lk.csiap.farmerdatasystem.service;

import lk.csiap.farmerdatasystem.dto.DashboardSummary;
import lk.csiap.farmerdatasystem.dto.DistrictCount;
import lk.csiap.farmerdatasystem.dto.DistrictStatistics;
import lk.csiap.farmerdatasystem.dto.DistrictYield;
import lk.csiap.farmerdatasystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    /**
     * Get all distinct district names from farmer data.
     */
    public List<String> getAllDistricts() {
        return farmerRepository.findAllDistricts();
    }

    /**
     * Get statistics for a specific district.
     */
    public DistrictStatistics getDistrictStatistics(String district) {
        DistrictStatistics stats = new DistrictStatistics();
        stats.setDistrict(district);

        stats.setFarmerCount(farmerRepository.countByDistrict(district));
        stats.setEquipmentCount(equipmentRepository.countByDistrict(district));
        stats.setHomeGardenCount(homeGardenRepository.countByDistrict(district));
        stats.setCsaAgricultureCount(csaAgricultureRepository.countByDistrict(district));
        stats.setAgroWellCount(agroWellRepository.countByDistrict(district));
        stats.setPoultryFarmCount(poultryRepository.countByDistrict(district));

        // Sum yield from CSA and AgroWell for this district
        Double csaYield = csaAgricultureRepository.sumYieldByDistrict(district);
        Double agroWellYield = agroWellRepository.sumYieldByDistrict(district);
        stats.setTotalYieldKg((csaYield != null ? csaYield : 0.0) + (agroWellYield != null ? agroWellYield : 0.0));

        // Sum income from all sources for this district
        Double csaIncome = csaAgricultureRepository.sumIncomeByDistrict(district);
        Double agroWellIncome = agroWellRepository.sumIncomeByDistrict(district);
        Double homeGardenIncome = homeGardenRepository.sumIncomeByDistrict(district);
        Double poultryIncome = poultryRepository.sumIncomeByDistrict(district);

        double totalIncome = (csaIncome != null ? csaIncome : 0.0)
                + (agroWellIncome != null ? agroWellIncome : 0.0)
                + (homeGardenIncome != null ? homeGardenIncome : 0.0)
                + (poultryIncome != null ? poultryIncome : 0.0);
        stats.setTotalIncomeRs(totalIncome);

        return stats;
    }

    /**
     * Get aggregated statistics for all districts with farmer data.
     */
    public List<DistrictStatistics> getAllDistrictStatistics() {
        // Collect all district names from all data sources
        Set<String> allDistricts = new LinkedHashSet<>();

        // Use grouped queries for efficiency
        Map<String, Long> farmerCounts = farmerRepository.countByDistrictGrouped().stream()
                .collect(Collectors.toMap(DistrictCount::getDistrict, DistrictCount::getCount, (a, b) -> a));
        Map<String, Long> equipmentCounts = equipmentRepository.countByDistrictGrouped().stream()
                .collect(Collectors.toMap(DistrictCount::getDistrict, DistrictCount::getCount, (a, b) -> a));
        Map<String, Long> homeGardenCounts = homeGardenRepository.countByDistrictGrouped().stream()
                .collect(Collectors.toMap(DistrictCount::getDistrict, DistrictCount::getCount, (a, b) -> a));
        Map<String, Long> csaCounts = csaAgricultureRepository.countByDistrictGrouped().stream()
                .collect(Collectors.toMap(DistrictCount::getDistrict, DistrictCount::getCount, (a, b) -> a));
        Map<String, Long> agroWellCounts = agroWellRepository.countByDistrictGrouped().stream()
                .collect(Collectors.toMap(DistrictCount::getDistrict, DistrictCount::getCount, (a, b) -> a));
        Map<String, Long> poultryCounts = poultryRepository.countByDistrictGrouped().stream()
                .collect(Collectors.toMap(DistrictCount::getDistrict, DistrictCount::getCount, (a, b) -> a));

        // Yield/income maps from CSA and AgroWell
        Map<String, Double> csaYields = new HashMap<>();
        Map<String, Double> csaIncomes = new HashMap<>();
        for (DistrictYield dy : csaAgricultureRepository.sumYieldAndIncomeByDistrictGrouped()) {
            csaYields.put(dy.getDistrict(), dy.getTotalYield());
            csaIncomes.put(dy.getDistrict(), dy.getTotalIncome());
        }

        Map<String, Double> agroWellYields = new HashMap<>();
        Map<String, Double> agroWellIncomes = new HashMap<>();
        for (DistrictYield dy : agroWellRepository.sumYieldAndIncomeByDistrictGrouped()) {
            agroWellYields.put(dy.getDistrict(), dy.getTotalYield());
            agroWellIncomes.put(dy.getDistrict(), dy.getTotalIncome());
        }

        allDistricts.addAll(farmerCounts.keySet());
        allDistricts.addAll(equipmentCounts.keySet());
        allDistricts.addAll(homeGardenCounts.keySet());
        allDistricts.addAll(csaCounts.keySet());
        allDistricts.addAll(agroWellCounts.keySet());
        allDistricts.addAll(poultryCounts.keySet());

        List<DistrictStatistics> result = new ArrayList<>();

        for (String district : allDistricts) {
            DistrictStatistics stats = new DistrictStatistics();
            stats.setDistrict(district);
            stats.setFarmerCount(farmerCounts.getOrDefault(district, 0L));
            stats.setEquipmentCount(equipmentCounts.getOrDefault(district, 0L));
            stats.setHomeGardenCount(homeGardenCounts.getOrDefault(district, 0L));
            stats.setCsaAgricultureCount(csaCounts.getOrDefault(district, 0L));
            stats.setAgroWellCount(agroWellCounts.getOrDefault(district, 0L));
            stats.setPoultryFarmCount(poultryCounts.getOrDefault(district, 0L));

            double totalYield = csaYields.getOrDefault(district, 0.0) + agroWellYields.getOrDefault(district, 0.0);
            stats.setTotalYieldKg(totalYield);

            double totalIncome = csaIncomes.getOrDefault(district, 0.0) + agroWellIncomes.getOrDefault(district, 0.0);
            stats.setTotalIncomeRs(totalIncome);

            result.add(stats);
        }

        // Sort by farmer count descending
        result.sort((a, b) -> Long.compare(b.getFarmerCount(), a.getFarmerCount()));
        return result;
    }
}
