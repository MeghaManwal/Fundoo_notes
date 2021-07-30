package com.microservices.notesservice.service;

import java.util.List;
import java.util.UUID;

import com.microservices.notesservice.dto.EditLabelDTO;
import com.microservices.notesservice.dto.LabelDTO;
import com.microservices.notesservice.model.LabelDetailsModel;
import com.microservices.notesservice.model.NoteDetailsModel;

public interface ILabelService {
    LabelDetailsModel addLabel(String userIdToken, LabelDTO addLabelDto);

    List<LabelDetailsModel> setListOfLabel(String userIdToken);

    LabelDetailsModel updateLabel(String userIdToken, EditLabelDTO addLabelDto);

    String deleteLabelDetails(String userIdToken, UUID labelId);

    NoteDetailsModel addLabelNote(String token, UUID labelId, UUID noteId);

    NoteDetailsModel addNewLabelToExistingNote(String token, UUID noteId, LabelDTO addLabelDto);

    List<LabelDetailsModel> getLabelByNotes(String userIdToken, UUID noteId);

    String deleteLabelFromNote(String token, UUID labelId, UUID noteId);
}
