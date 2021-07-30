package com.microservices.notesservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public @Data class LabelDetailsModel {

    @Id
    @GeneratedValue(generator = "uuid2",strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    public UUID labelId;

    @NotNull
    @Column(name = "label_name")
    private String labelName;

    @NotNull
    @Column(name = "user_id")
    @Type(type = "uuid-char")
    private UUID userId;


    @Column(name = "label_created_date")
    private LocalDateTime createdDate= LocalDateTime.now();


    @Column(name = "label_updated_date")
    private LocalDateTime updatedDate;

    @JsonIgnoreProperties(value = "labels")
    @ManyToMany(mappedBy = "labels", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<NoteDetailsModel> notes;

    public LabelDetailsModel(String labelName) {
        this.labelName=labelName;
    }
    
    public LabelDetailsModel() {}
}
