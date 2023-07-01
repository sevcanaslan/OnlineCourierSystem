package com.couriersystem.dto.response;

import com.couriersystem.repository.entity.enums.Roles;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerFindAllResponseDto {

    String email;
    String password;
    Roles role;
}
