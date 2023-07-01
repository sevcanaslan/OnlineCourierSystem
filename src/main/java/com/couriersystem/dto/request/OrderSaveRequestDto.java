package com.couriersystem.dto.request;

import com.couriersystem.repository.entity.Parcel;
import com.couriersystem.repository.entity.Payment;
import com.couriersystem.repository.entity.User;
import com.couriersystem.repository.entity.enums.OrderStatus;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderSaveRequestDto {
    String orderNumber;
    String name;
    Long customerId; // Müşterinin ID'si
    Long courierId; // Kuryenin ID'si
    String pickupLocation;
    String deliveryLocation;
    OrderStatus orderStatus;
    List<Long> parcelIds;
    Long paymentId;

}
