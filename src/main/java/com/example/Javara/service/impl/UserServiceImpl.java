package com.example.Javara.service.impl;

import com.example.Javara.dto.UserRequestDto;
import com.example.Javara.dto.UserResponseDto;
import com.example.Javara.entity.User;
import com.example.Javara.repository.UserRepository;
import com.example.Javara.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User user = User.builder()
                .password(passwordEncoder.encode(userRequestDto.getPassword()))
                .name(userRequestDto.getName())
                .gender(userRequestDto.getGender())
                .role(userRequestDto.getRole())
                .policeCode(userRequestDto.getPoliceCode())
                .patrolStatus(userRequestDto.getPatrolStatus())
                .edgeDeviceId(userRequestDto.getEdgeDeviceId())
                .build();
        User savedUser = userRepository.save(user);
        return toResponseDto(savedUser);
    }

    @Override
    public List<UserResponseDto> getAllusers() {
        return userRepository.findAll().stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
        return toResponseDto(user);
    }

    @Override
    public UserResponseDto updateUser(Long userId, UserRequestDto userRequestDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        user.setName(userRequestDto.getName());
        user.setGender(userRequestDto.getGender());
        user.setRole(userRequestDto.getRole());
        user.setPoliceCode(userRequestDto.getPoliceCode());
        user.setPatrolStatus(userRequestDto.getPatrolStatus());
        user.setEdgeDeviceId(userRequestDto.getEdgeDeviceId());

        User updatedUser = userRepository.save(user);
        return toResponseDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    private UserResponseDto toResponseDto(User user) {
        UserResponseDto dto = new UserResponseDto();

        dto.setUserId(user.getUserId());
        dto.setName(user.getName());
        dto.setGender(user.getGender());
        dto.setRole(user.getRole());
        dto.setPoliceCode(user.getPoliceCode());
        dto.setPatrolStatus(user.getPatrolStatus());
        dto.setEdgeDeviceId(user.getEdgeDeviceId());

        return dto;
    }
}
