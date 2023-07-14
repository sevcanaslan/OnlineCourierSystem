package com.couriersystem.mapper;

import com.couriersystem.dto.request.ParcelSaveRequestDto;
import com.couriersystem.repository.entity.Parcel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-11T00:25:38+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class IParcelMapperImpl implements IParcelMapper {

    @Override
    public Parcel toParcelFromParcelSaveRequestDto(ParcelSaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Parcel.ParcelBuilder<?, ?> parcel = Parcel.builder();

        parcel.parcelNumber( dto.getParcelNumber() );
        parcel.description( dto.getDescription() );
        parcel.weigth( dto.getWeigth() );
        parcel.size( dto.getSize() );

        return parcel.build();
    }
}
