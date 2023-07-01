package com.couriersystem.mapper;

import com.couriersystem.dto.request.CustomerSaveRequestDto;
import com.couriersystem.dto.request.CustomerUpdateRequestDto;
import com.couriersystem.dto.response.CustomerFindAllResponseDto;
import com.couriersystem.dto.response.CustomerFindByIdResponseDto;
import com.couriersystem.repository.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-22T18:11:38+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class IUserMapperImpl implements IUserMapper {

    @Override
    public User toUserFromCustomerSaveDto(CustomerSaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder<?, ?> user = User.builder();

        user.name( dto.getName() );
        user.middleName( dto.getMiddleName() );
        user.lastName( dto.getLastName() );
        user.TC( dto.getTC() );
        user.email( dto.getEmail() );
        user.password( dto.getPassword() );

        return user.build();
    }

    @Override
    public User toUserFromCustomerUpdateRequestDto(CustomerUpdateRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder<?, ?> user = User.builder();

        user.name( dto.getName() );
        user.middleName( dto.getMiddleName() );
        user.lastName( dto.getLastName() );
        user.TC( dto.getTC() );
        user.email( dto.getEmail() );
        user.password( dto.getPassword() );
        user.role( dto.getRole() );

        return user.build();
    }

    @Override
    public CustomerFindAllResponseDto toCustomerFindAllResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        CustomerFindAllResponseDto.CustomerFindAllResponseDtoBuilder customerFindAllResponseDto = CustomerFindAllResponseDto.builder();

        customerFindAllResponseDto.email( user.getEmail() );
        customerFindAllResponseDto.password( user.getPassword() );
        customerFindAllResponseDto.role( user.getRole() );

        return customerFindAllResponseDto.build();
    }

    @Override
    public CustomerFindByIdResponseDto toCustomerFindByIdResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        CustomerFindByIdResponseDto.CustomerFindByIdResponseDtoBuilder customerFindByIdResponseDto = CustomerFindByIdResponseDto.builder();

        customerFindByIdResponseDto.email( user.getEmail() );
        customerFindByIdResponseDto.password( user.getPassword() );
        customerFindByIdResponseDto.role( user.getRole() );

        return customerFindByIdResponseDto.build();
    }
}
