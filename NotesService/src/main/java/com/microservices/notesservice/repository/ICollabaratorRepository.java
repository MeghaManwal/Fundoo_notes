package com.microservices.notesservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.notesservice.model.CollaboratorDetailsModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ICollabaratorRepository extends JpaRepository<CollaboratorDetailsModel, UUID> {

    List<CollaboratorDetailsModel> findByUserId(UUID userId);
    Optional<CollaboratorDetailsModel> findByCollabEmailAndUserId(String emailId,UUID userId);


}
