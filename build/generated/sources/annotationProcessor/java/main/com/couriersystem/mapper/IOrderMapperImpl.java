package com.couriersystem.mapper;

import com.couriersystem.dto.request.OrderSaveRequestDto;
import com.couriersystem.dto.request.OrderUpdateRequestDto;
import com.couriersystem.dto.response.OrderFindAllResponseDto;
import com.couriersystem.dto.response.OrderFindByIdResponseDto;
import com.couriersystem.repository.entity.Order;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-11T00:25:37+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class IOrderMapperImpl implements IOrderMapper {

    @Override
    public Order toOrderFromOrderSaveDto(OrderSaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Order.OrderBuilder<?, ?> order = Order.builder();

        order.orderNumber( dto.getOrderNumber() );
        order.pickupLocation( dto.getPickupLocation() );
        order.deliveryLocation( dto.getDeliveryLocation() );
        order.orderStatus( dto.getOrderStatus() );

        return order.build();
    }

    @Override
    public Order toOrderFromOrderUpdateRequestDto(OrderUpdateRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Order.OrderBuilder<?, ?> order = Order.builder();

        order.orderNumber( dto.getOrderNumber() );
        order.pickupLocation( dto.getPickupLocation() );
        order.deliveryLocation( dto.getDeliveryLocation() );
        order.orderStatus( dto.getOrderStatus() );

        return order.build();
    }

    @Override
    public OrderFindAllResponseDto toOrderFindAllResponseDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderFindAllResponseDto orderFindAllResponseDto = new OrderFindAllResponseDto();

        return orderFindAllResponseDto;
    }

    @Override
    public OrderFindByIdResponseDto toOrderFindByIdResponseDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderFindByIdResponseDto orderFindByIdResponseDto = new OrderFindByIdResponseDto();

        return orderFindByIdResponseDto;
    }
}
