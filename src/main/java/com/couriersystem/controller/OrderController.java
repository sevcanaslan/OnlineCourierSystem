package com.couriersystem.controller;

import com.couriersystem.dto.request.OrderSaveRequestDto;
import com.couriersystem.dto.response.OrderSaveResponseDto;
import com.couriersystem.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.couriersystem.constants.EndPoints.*;
@RestController
@RequestMapping(ORDER)
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;


//    Order ile ilgili endpointler:
//    POST /orders: Yeni bir sipariş oluştur.
//    GET /orders: Tüm siparişleri listele.
//    GET /orders/{orderId}: Belirli bir siparişin detaylarını getir.
//    PUT /orders/{orderId}: Belirli bir siparişin detaylarını güncelle.
//    DELETE /orders/{orderId}: Belirli bir siparişi sil.

    @PostMapping(SAVE)
    ResponseEntity<OrderSaveResponseDto> saveOrder(@RequestBody OrderSaveRequestDto saveRequestDto){
        return ResponseEntity.ok(orderService.saveOrder(saveRequestDto));
    }

}
