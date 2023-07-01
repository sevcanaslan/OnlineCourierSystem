package com.couriersystem.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper=false)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="tbl_parcel")
public class Parcel extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String parcelNumber;
    private String description;
    private float weigth;
    private float size;

    @ManyToOne(cascade = CascadeType.ALL)
    private Order order;
}
