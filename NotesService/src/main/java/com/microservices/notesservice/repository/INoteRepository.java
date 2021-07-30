package com.microservices.notesservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.notesservice.model.NoteDetailsModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface  INoteRepository extends JpaRepository<NoteDetailsModel, UUID> {
          Optional<NoteDetailsModel> findByTitle(String title);
          List<NoteDetailsModel> findByUserId(UUID userId);
          Optional<NoteDetailsModel> findByNoteIdAndUserId(UUID noteId,UUID userId);

}
