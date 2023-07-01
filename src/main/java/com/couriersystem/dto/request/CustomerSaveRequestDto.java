package com.couriersystem.dto.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerSaveRequestDto {
    String name;
    String middleName;
    String lastName;
    String TC;
    String email;
    String password;



}
