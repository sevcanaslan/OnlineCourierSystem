package com.couriersystem.service;

import com.couriersystem.dto.request.ParcelSaveRequestDto;
import com.couriersystem.dto.response.ParcelSaveResponseDto;
import com.couriersystem.mapper.IParcelMapper;
import com.couriersystem.repository.IOrderRepository;
import com.couriersystem.repository.IParcelRepository;
import com.couriersystem.repository.entity.Order;
import com.couriersystem.repository.entity.Parcel;
import com.couriersystem.utility.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParcelService extends ServiceManager<Parcel,Long> {

    private final IParcelRepository parcelRepository;
    private final IOrderRepository orderRepository;

    public ParcelService(IParcelRepository parcelRepository,
                         IOrderRepository orderRepository) {
        super(parcelRepository);
        this.parcelRepository=parcelRepository;
        this.orderRepository=orderRepository;
    }

    public ParcelSaveResponseDto saveParcel(ParcelSaveRequestDto requestDto) {
        Optional<Parcel> parcelOptional=parcelRepository.findOptionalByParcelNumber(requestDto.getParcelNumber());
        if (parcelOptional.isPresent()){
            throw new RuntimeException("Parcel already exists with this number: " + requestDto.getParcelNumber());
        }
        Parcel parcel= IParcelMapper.INSTANCE.toParcelFromParcelSaveRequestDto(requestDto);
        parcel.setParcelNumber(requestDto.getParcelNumber());
        parcel.setDescription(requestDto.getDescription());
        parcel.setSize(requestDto.getSize());
        parcel.setWeigth(requestDto.getWeigth());
        Parcel savedParcel = parcelRepository.save(parcel);

        ParcelSaveResponseDto responseDto= new ParcelSaveResponseDto();
        responseDto.setParcelNumber(savedParcel.getParcelNumber());
        return responseDto;
    }

}
