package lk.csiap.farmerdatasystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long userId;
    private String username;
    private String email;
    private String fullName;
    private String role;
    private Boolean enabled;
    private String createdAt;
    private String updatedAt;
}
