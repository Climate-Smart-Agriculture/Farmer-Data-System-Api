package lk.csiap.farmerdatasystem.controller;

import jakarta.validation.Valid;
import lk.csiap.farmerdatasystem.dto.ApiResponse;
import lk.csiap.farmerdatasystem.dto.CreateUserRequest;
import lk.csiap.farmerdatasystem.dto.UpdateUserRequest;
import lk.csiap.farmerdatasystem.dto.UserDto;
import lk.csiap.farmerdatasystem.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
@PreAuthorize("hasRole('ADMIN')")
public class UserManagementController {

    @Autowired
    private UserManagementService userManagementService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<UserDto>>> getAllUsers() {
        List<UserDto> users = userManagementService.getAllUsers();
        return ResponseEntity.ok(ApiResponse.success("Users retrieved successfully", users));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDto>> getUserById(@PathVariable Long id) {
        UserDto user = userManagementService.getUserById(id);
        return ResponseEntity.ok(ApiResponse.success("User retrieved successfully", user));
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<ApiResponse<List<UserDto>>> getUsersByRole(@PathVariable String role) {
        List<UserDto> users = userManagementService.getUsersByRole(role);
        return ResponseEntity.ok(ApiResponse.success("Users retrieved successfully", users));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserDto>> createUser(@Valid @RequestBody CreateUserRequest request) {
        UserDto user = userManagementService.createUser(request);
        return ResponseEntity.ok(ApiResponse.success("User created successfully", user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDto>> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UpdateUserRequest request) {
        UserDto user = userManagementService.updateUser(id, request);
        return ResponseEntity.ok(ApiResponse.success("User updated successfully", user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id) {
        userManagementService.deleteUser(id);
        return ResponseEntity.ok(ApiResponse.success("User deleted successfully", null));
    }
}
