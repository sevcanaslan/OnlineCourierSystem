package com.couriersystem.mapper;

import com.couriersystem.dto.request.CustomerSaveRequestDto;
import com.couriersystem.dto.request.CustomerUpdateRequestDto;
import com.couriersystem.dto.request.OrderSaveRequestDto;
import com.couriersystem.dto.request.OrderUpdateRequestDto;
import com.couriersystem.dto.response.CustomerFindAllResponseDto;
import com.couriersystem.dto.response.CustomerFindByIdResponseDto;
import com.couriersystem.dto.response.OrderFindAllResponseDto;
import com.couriersystem.dto.response.OrderFindByIdResponseDto;
import com.couriersystem.repository.entity.Order;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IOrderMapper {
    IOrderMapper INSTANCE= Mappers.getMapper(IOrderMapper.class);


    Order toOrderFromOrderSaveDto(final OrderSaveRequestDto dto);
    Order toOrderFromOrderUpdateRequestDto(final OrderUpdateRequestDto dto);
    OrderFindAllResponseDto toOrderFindAllResponseDto(Order order);
    OrderFindByIdResponseDto toOrderFindByIdResponseDto (Order order);
}
