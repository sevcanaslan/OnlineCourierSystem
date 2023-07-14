package com.couriersystem.service;

import com.couriersystem.dto.request.LoginRequestDto;
import com.couriersystem.dto.response.LoginResponseDto;
import com.couriersystem.repository.IUserRepository;
import com.couriersystem.repository.entity.User;
import com.couriersystem.utility.JwtService;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;

@Service
public class AuthService {
    private final IUserRepository userRepository;
    private final JwtService jwtService;

    public AuthService(IUserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public LoginResponseDto login(LoginRequestDto dto) {
        Optional<User> optionalUser = userRepository.findOptionalByEmail(dto.getEmail());
        Optional<User> optionalUser2 = userRepository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());

        if (optionalUser.isEmpty()) {
            throw new NotFoundException("User not found with email: " + dto.getEmail());
        }
        if (optionalUser2.isEmpty()) {
            throw new NotFoundException("Password is not correct");
        }


        Long userId = optionalUser2.get().getId();
        String token = jwtService.createToken(userId, "ROLE_USER").orElseThrow(() -> new RuntimeException("Failed to create JWT token"));

        LoginResponseDto responseDto = new LoginResponseDto();
        responseDto.setMessage("Giriş yapıldı");
        responseDto.setToken(token);

        return responseDto;
    }
}
