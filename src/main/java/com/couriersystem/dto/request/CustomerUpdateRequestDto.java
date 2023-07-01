package com.couriersystem.dto.request;

import com.couriersystem.repository.entity.enums.Roles;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerUpdateRequestDto {
    String name;
    String middleName;
    String lastName;
    String TC;
    String email;
    String password;
    Roles role;
}
