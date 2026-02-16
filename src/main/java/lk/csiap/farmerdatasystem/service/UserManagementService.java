package lk.csiap.farmerdatasystem.service;

import lk.csiap.farmerdatasystem.dto.CreateUserRequest;
import lk.csiap.farmerdatasystem.dto.UpdateUserRequest;
import lk.csiap.farmerdatasystem.dto.UserDto;
import lk.csiap.farmerdatasystem.entity.User;
import lk.csiap.farmerdatasystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManagementService {

    private static final List<String> VALID_ROLES = Arrays.asList("ADMIN", "AG", "GN");

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return toDto(user);
    }

    public List<UserDto> getUsersByRole(String role) {
        return userRepository.findByRole(role.toUpperCase()).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public UserDto createUser(CreateUserRequest request) {
        // Validate role
        String role = request.getRole().toUpperCase();
        if (!VALID_ROLES.contains(role)) {
            throw new RuntimeException("Invalid role. Must be one of: ADMIN, AG, GN");
        }

        // Check uniqueness
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setFullName(request.getFullName());
        user.setRole(role);
        user.setEnabled(true);

        User savedUser = userRepository.save(user);
        return toDto(savedUser);
    }

    public UserDto updateUser(Long id, UpdateUserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        if (request.getUsername() != null && !request.getUsername().isBlank()) {
            // Check if username is taken by another user
            userRepository.findByUsername(request.getUsername())
                    .ifPresent(existing -> {
                        if (!existing.getUserId().equals(id)) {
                            throw new RuntimeException("Username already exists");
                        }
                    });
            user.setUsername(request.getUsername());
        }

        if (request.getEmail() != null && !request.getEmail().isBlank()) {
            // Check if email taken by another user
            userRepository.findByEmail(request.getEmail())
                    .ifPresent(existing -> {
                        if (!existing.getUserId().equals(id)) {
                            throw new RuntimeException("Email already exists");
                        }
                    });
            user.setEmail(request.getEmail());
        }

        if (request.getPassword() != null && !request.getPassword().isBlank()) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }

        if (request.getFullName() != null) {
            user.setFullName(request.getFullName());
        }

        if (request.getRole() != null && !request.getRole().isBlank()) {
            String role = request.getRole().toUpperCase();
            if (!VALID_ROLES.contains(role)) {
                throw new RuntimeException("Invalid role. Must be one of: ADMIN, AG, GN");
            }
            user.setRole(role);
        }

        if (request.getEnabled() != null) {
            user.setEnabled(request.getEnabled());
        }

        User savedUser = userRepository.save(user);
        return toDto(savedUser);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        userRepository.delete(user);
    }

    private UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setUserId(user.getUserId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setFullName(user.getFullName());
        dto.setRole(user.getRole());
        dto.setEnabled(user.getEnabled());
        dto.setCreatedAt(user.getCreatedAt() != null ? user.getCreatedAt().toString() : null);
        dto.setUpdatedAt(user.getUpdatedAt() != null ? user.getUpdatedAt().toString() : null);
        return dto;
    }
}
