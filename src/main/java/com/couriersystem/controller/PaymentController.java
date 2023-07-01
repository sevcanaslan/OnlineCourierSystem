package com.couriersystem.controller;

import com.couriersystem.dto.request.PaymentSaveRequestDto;
import com.couriersystem.dto.response.PaymentSaveResponseDto;
import com.couriersystem.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.couriersystem.constants.EndPoints.*;

@RestController
@RequestMapping(PAYMENT)
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping(SAVE)
    ResponseEntity<PaymentSaveResponseDto> savePayment(@RequestBody PaymentSaveRequestDto requestDto){
        return ResponseEntity.ok(paymentService.savePayment(requestDto));
    }

}
