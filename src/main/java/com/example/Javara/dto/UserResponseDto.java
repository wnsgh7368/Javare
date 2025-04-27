package com.example.Javara.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserResponseDto {
    private Long userId;
    private String name;
    private String gender;
    private String role;
    private String policeCode;
    private String patrolStatus;
    private Long edgeDeviceId;
    private LocalDateTime createdAt;
}
