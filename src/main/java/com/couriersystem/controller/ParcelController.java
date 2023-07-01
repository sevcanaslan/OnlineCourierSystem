package com.couriersystem.controller;

import com.couriersystem.dto.request.ParcelSaveRequestDto;
import com.couriersystem.dto.response.ParcelSaveResponseDto;
import com.couriersystem.service.ParcelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.couriersystem.constants.EndPoints.*;
@RestController
@RequestMapping(PARCEL)
@RequiredArgsConstructor
public class ParcelController {

    private final ParcelService parcelService;

    @PostMapping(SAVE)
    ResponseEntity<ParcelSaveResponseDto> saveParcel(@RequestBody ParcelSaveRequestDto requestDto){
        return ResponseEntity.ok(parcelService.saveParcel(requestDto));
    }
}
