package com.couriersystem.dto.request;

import com.couriersystem.repository.entity.enums.Status;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentSaveRequestDto {

    String amount;
    String paymentMethod;
    Status paymentStatus;
    String paymentNumber;

}
