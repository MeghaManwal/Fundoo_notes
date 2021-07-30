package com.microservices.notesservice.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

import com.microservices.notesservice.model.LabelDetailsModel;

import java.util.List;
import java.util.UUID;

@Data
public class LabelToNoteDTO {

    @NotNull(message = "The noteId field should not be empty")
    private UUID noteId;

    private List<LabelDetailsModel> labels;
}
