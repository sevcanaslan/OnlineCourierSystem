package com.couriersystem.dto.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ParcelSaveRequestDto {
    String description;
    float weigth;
    float size;
    String parcelNumber;

}
