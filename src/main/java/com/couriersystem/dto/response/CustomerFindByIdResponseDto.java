package com.couriersystem.dto.response;

import com.couriersystem.repository.entity.enums.Roles;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerFindByIdResponseDto {
    String email;
    String password;
    Roles role;
}
