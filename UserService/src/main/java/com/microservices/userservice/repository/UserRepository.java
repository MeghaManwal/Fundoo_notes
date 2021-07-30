package com.microservices.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.userservice.model.UserDetailsModel;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserDetailsModel, UUID> {

    Optional<UserDetailsModel> findByEmailID(String emailID);
}
