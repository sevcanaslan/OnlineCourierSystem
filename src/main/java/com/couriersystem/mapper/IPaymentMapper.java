package com.couriersystem.mapper;

import com.couriersystem.dto.request.PaymentSaveRequestDto;
import com.couriersystem.repository.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IPaymentMapper {
    IPaymentMapper INSTANCE= Mappers.getMapper(IPaymentMapper.class);
    Payment toPaymentFromPaymentSaveRequestDto(final PaymentSaveRequestDto dto);
}
