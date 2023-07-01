package com.couriersystem.repository;

import com.couriersystem.repository.entity.Order;
import com.couriersystem.repository.entity.enums.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IOrderRepository extends JpaRepository<Order,Long> {

    Optional<Order> findOptionalByOrderNumber(String number);



}
