package com.couriersystem.repository;

import com.couriersystem.repository.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment,Long> {
    Optional<Payment> findOptionalById (Long id);
    Optional<Payment> findOptionalByPaymentNumber (String number);
}
