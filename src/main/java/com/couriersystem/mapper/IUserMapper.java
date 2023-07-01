package com.couriersystem.mapper;


import com.couriersystem.dto.request.CustomerSaveRequestDto;
import com.couriersystem.dto.request.CustomerUpdateRequestDto;
import com.couriersystem.dto.response.CustomerFindAllResponseDto;
import com.couriersystem.dto.response.CustomerFindByIdResponseDto;
import com.couriersystem.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IUserMapper {
    IUserMapper INSTANCE= Mappers.getMapper(IUserMapper.class);

    User toUserFromCustomerSaveDto(final CustomerSaveRequestDto dto);
    User toUserFromCustomerUpdateRequestDto(final CustomerUpdateRequestDto dto);
    CustomerFindAllResponseDto toCustomerFindAllResponseDto(User user);
    CustomerFindByIdResponseDto toCustomerFindByIdResponseDto (User user);
}
