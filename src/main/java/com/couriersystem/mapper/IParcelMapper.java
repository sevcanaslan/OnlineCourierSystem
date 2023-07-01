package com.couriersystem.mapper;

import com.couriersystem.dto.request.ParcelSaveRequestDto;
import com.couriersystem.repository.entity.Parcel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IParcelMapper {

    IParcelMapper INSTANCE= Mappers.getMapper(IParcelMapper.class);

    Parcel toParcelFromParcelSaveRequestDto(final ParcelSaveRequestDto dto);
}
