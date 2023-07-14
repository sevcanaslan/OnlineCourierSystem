package com.couriersystem.mapper;

import com.couriersystem.dto.request.PaymentSaveRequestDto;
import com.couriersystem.repository.entity.Payment;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-11T00:25:38+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class IPaymentMapperImpl implements IPaymentMapper {

    @Override
    public Payment toPaymentFromPaymentSaveRequestDto(PaymentSaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Payment.PaymentBuilder<?, ?> payment = Payment.builder();

        payment.paymentNumber( dto.getPaymentNumber() );
        payment.amount( dto.getAmount() );
        payment.paymentMethod( dto.getPaymentMethod() );
        payment.paymentStatus( dto.getPaymentStatus() );

        return payment.build();
    }
}
