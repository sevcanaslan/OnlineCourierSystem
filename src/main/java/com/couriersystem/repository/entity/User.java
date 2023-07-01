package com.couriersystem.repository.entity;

import com.couriersystem.repository.entity.enums.Roles;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="tbl_user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String middleName;
    private String lastName;
    private String TC;
    private String email;
    private String password;

    private Roles role;

    @OneToMany(mappedBy = "customer")
    private List<Order> customerOrderList;

    @OneToMany(mappedBy = "courier")
    private List<Order> courierOrderList;

}
