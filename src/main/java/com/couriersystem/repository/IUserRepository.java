package com.couriersystem.repository;

import com.couriersystem.repository.entity.User;
import com.couriersystem.repository.entity.enums.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository <User, Long> {

    Optional<User> findOptionalByEmail(String email);
    User findByEmail(String email);
    List<User> findByRole(Roles role);
    Optional<User> findOptionalById(Long customerId);
    Optional<User> findOptionalByEmailAndPassword(String email,String password);
}
