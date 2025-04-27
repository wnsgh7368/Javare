package com.example.Javara.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    private String password;
    private String name;
    private String gender;
    private String role; // "ADMIN" or "USER"
    private String policeCode;
    private String patrolStatus;
    private Long edgeDeviceId;
}

