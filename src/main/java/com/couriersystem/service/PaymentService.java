package com.couriersystem.service;

import com.couriersystem.dto.request.PaymentSaveRequestDto;
import com.couriersystem.dto.response.PaymentSaveResponseDto;
import com.couriersystem.mapper.IPaymentMapper;
import com.couriersystem.repository.IOrderRepository;
import com.couriersystem.repository.IPaymentRepository;
import com.couriersystem.repository.entity.Order;
import com.couriersystem.repository.entity.Payment;
import com.couriersystem.repository.entity.enums.Status;
import com.couriersystem.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService extends ServiceManager<Payment,Long> {

    private final IPaymentRepository paymentRepository;
    private final IOrderRepository orderRepository;

    public PaymentService(IPaymentRepository paymentRepository,
                          IOrderRepository orderRepository) {
        super(paymentRepository);
        this.paymentRepository=paymentRepository;
        this.orderRepository=orderRepository;

    }


    public PaymentSaveResponseDto savePayment(PaymentSaveRequestDto requestDto) {
        Optional<Payment> OpPayment = paymentRepository.findOptionalByPaymentNumber(requestDto.getPaymentNumber());
        if(OpPayment.isPresent()){
            throw new RuntimeException("Payment already exists with this number: " + requestDto.getPaymentNumber());
        }
        Payment payment= IPaymentMapper.INSTANCE.toPaymentFromPaymentSaveRequestDto(requestDto);
        payment.setPaymentNumber(requestDto.getPaymentNumber());
        payment.setPaymentMethod(requestDto.getPaymentMethod());
        payment.setPaymentStatus(requestDto.getPaymentStatus());
        payment.setAmount(requestDto.getAmount());
        Payment savedPayment = paymentRepository.save(payment);

        PaymentSaveResponseDto responseDto= new PaymentSaveResponseDto();
        responseDto.setPaymentNumber(savedPayment.getPaymentNumber());
        return responseDto;
    }
}
