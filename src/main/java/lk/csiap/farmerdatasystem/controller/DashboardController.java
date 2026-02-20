package lk.csiap.farmerdatasystem.controller;

import lk.csiap.farmerdatasystem.dto.ApiResponse;
import lk.csiap.farmerdatasystem.dto.DashboardSummary;
import lk.csiap.farmerdatasystem.dto.DistrictStatistics;
import lk.csiap.farmerdatasystem.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
// Global CORS configuration is in SecurityConfig.java
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/summary")
    public ResponseEntity<ApiResponse<DashboardSummary>> getDashboardSummary() {
        DashboardSummary summary = dashboardService.getDashboardSummary();
        return ResponseEntity.ok(ApiResponse.success("Dashboard summary retrieved successfully", summary));
    }

    @GetMapping("/districts")
    public ResponseEntity<ApiResponse<List<String>>> getAllDistricts() {
        List<String> districts = dashboardService.getAllDistricts();
        return ResponseEntity.ok(ApiResponse.success("Districts retrieved successfully", districts));
    }

    @GetMapping("/districts/statistics")
    public ResponseEntity<ApiResponse<List<DistrictStatistics>>> getAllDistrictStatistics() {
        List<DistrictStatistics> stats = dashboardService.getAllDistrictStatistics();
        return ResponseEntity.ok(ApiResponse.success("All district statistics retrieved successfully", stats));
    }

    @GetMapping("/districts/{district}")
    public ResponseEntity<ApiResponse<DistrictStatistics>> getDistrictStatistics(@PathVariable String district) {
        DistrictStatistics stats = dashboardService.getDistrictStatistics(district);
        return ResponseEntity.ok(ApiResponse.success("District statistics retrieved successfully", stats));
    }
}
