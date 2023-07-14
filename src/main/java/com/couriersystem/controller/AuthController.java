package com.couriersystem.controller;

import com.couriersystem.dto.request.LoginRequestDto;
import com.couriersystem.dto.response.LoginResponseDto;
import com.couriersystem.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    @CrossOrigin("*")
    ResponseEntity<LoginResponseDto> login (@RequestBody LoginRequestDto dto){
        return ResponseEntity.ok(authService.login(dto));
    }

}
