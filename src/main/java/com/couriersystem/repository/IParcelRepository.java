package com.couriersystem.repository;

import com.couriersystem.repository.entity.Parcel;
import com.couriersystem.repository.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IParcelRepository extends JpaRepository<Parcel,Long> {

    Optional<Parcel> findOptionalByParcelNumber (String number);
}
