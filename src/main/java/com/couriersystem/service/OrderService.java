package com.couriersystem.service;

import com.couriersystem.dto.request.OrderSaveRequestDto;
import com.couriersystem.dto.response.OrderSaveResponseDto;
import com.couriersystem.mapper.IOrderMapper;
import com.couriersystem.repository.IOrderRepository;
import com.couriersystem.repository.IParcelRepository;
import com.couriersystem.repository.IPaymentRepository;
import com.couriersystem.repository.IUserRepository;
import com.couriersystem.repository.entity.Order;
import com.couriersystem.repository.entity.Parcel;
import com.couriersystem.repository.entity.Payment;
import com.couriersystem.repository.entity.User;
import com.couriersystem.repository.entity.enums.OrderStatus;
import com.couriersystem.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService extends ServiceManager<Order,Long> {

    private final IOrderRepository orderRepository;
    private final IUserRepository userRepository;
    private final IPaymentRepository paymentRepository;
    private final IParcelRepository parcelRepository;
    public OrderService(IOrderRepository orderRepository,
                        IUserRepository userRepository,
                        IPaymentRepository paymentRepository,
                        IParcelRepository parcelRepository) {
        super(orderRepository);
        this.orderRepository=orderRepository;
        this.userRepository=userRepository;
        this.paymentRepository=paymentRepository;
        this.parcelRepository= parcelRepository;
    }

    public OrderSaveResponseDto saveOrder(OrderSaveRequestDto saveRequestDto) {
        Optional<Order> OptionalOrder= orderRepository.findOptionalByOrderNumber(saveRequestDto.getOrderNumber());
        if(OptionalOrder.isPresent()){
            throw new RuntimeException("Order already exists with this number: " +saveRequestDto.getOrderNumber());
        }

        Optional<User> customerOptional= userRepository.findOptionalById(saveRequestDto.getCustomerId());
        if(customerOptional.isEmpty()){
            throw new RuntimeException("Customer not found with id: "+saveRequestDto.getCustomerId());
        }
        User customer=customerOptional.get();

        Optional<User> courierOptional= userRepository.findOptionalById(saveRequestDto.getCourierId());
        if(courierOptional.isEmpty()){
            throw new RuntimeException("Courier not found with id: "+saveRequestDto.getCourierId());
        }
        User courier=courierOptional.get();

        Optional<Payment> paymentOptional= paymentRepository.findOptionalById(saveRequestDto.getPaymentId());
        if(paymentOptional.isEmpty()){
            throw new RuntimeException("Payment not found with id: "+saveRequestDto.getPaymentId());
        }
        Payment payment=paymentOptional.get();

        List<Parcel> parcels = new ArrayList<>();
        for(Long parcelId : saveRequestDto.getParcelIds()){
            Optional<Parcel> parcelOptional = parcelRepository.findById(parcelId);
            if(parcelOptional.isEmpty()){
                throw new RuntimeException("Parcel not found with id: " + parcelId);
            }
            parcels.add(parcelOptional.get());
        }

        Order order= IOrderMapper.INSTANCE.toOrderFromOrderSaveDto(saveRequestDto);
        order.setOrderStatus(OrderStatus.NEW);
        order.setOrderNumber(saveRequestDto.getOrderNumber());
        order.setCustomer(customer);
        order.setCourier(courier);
        order.setPickupLocation(saveRequestDto.getPickupLocation());
        order.setDeliveryLocation(saveRequestDto.getDeliveryLocation());
        order.setPayment(payment);
        order.setParcels(parcels);
        Order savedOrder = orderRepository.save(order);

        OrderSaveResponseDto responseDto= new OrderSaveResponseDto();
        responseDto.setMessage("Order with number " + savedOrder.getOrderNumber() + " placed");

        return responseDto;
    }
}
