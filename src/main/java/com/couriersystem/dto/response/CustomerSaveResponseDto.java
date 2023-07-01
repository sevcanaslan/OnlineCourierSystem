package com.couriersystem.dto.response;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerSaveResponseDto {
    Long id;
    String email;
}
