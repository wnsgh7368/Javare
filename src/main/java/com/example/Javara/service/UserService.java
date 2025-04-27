package com.example.Javara.service;

import com.example.Javara.dto.UserRequestDto;
import com.example.Javara.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserRequestDto userRequestDto);
    List<UserResponseDto> getAllusers();
    UserResponseDto getUserById(Long userId);
    UserResponseDto updateUser(Long userId, UserRequestDto userRequestDto);
    void deleteUser(Long userId);
}
