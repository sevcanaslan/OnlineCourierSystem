package com.couriersystem.dto.response;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentSaveResponseDto {
    String paymentNumber;

}
