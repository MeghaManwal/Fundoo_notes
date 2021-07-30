package com.microservices.notesservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.microservices.notesservice.dto.EditLabelDTO;
import com.microservices.notesservice.dto.LabelDTO;
import com.microservices.notesservice.dto.ResponseDTO;
import com.microservices.notesservice.model.LabelDetailsModel;
import com.microservices.notesservice.model.NoteDetailsModel;
import com.microservices.notesservice.service.ILabelService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/label_api")
@CrossOrigin
public class LabelController {

    @Autowired
    ILabelService labelService;

    @PostMapping("/adding_label")
    public ResponseEntity addLabel(@RequestHeader(name = "userId") String userIdToken,
                                   @RequestBody @Valid LabelDTO addLabelDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<ResponseDTO>(new ResponseDTO(bindingResult.getAllErrors().get(0).
                    getDefaultMessage(), "100", null),
                    HttpStatus.BAD_REQUEST);
        }
        LabelDetailsModel labelDetailsModel = labelService.addLabel(userIdToken, addLabelDto);

        return new ResponseEntity(new ResponseDTO("THE LABEL ADDED SUCCESSFULLY ", "200", labelDetailsModel),HttpStatus.OK);
    }

    @GetMapping("/getting_all_label")
    public ResponseEntity getLabel(@RequestHeader(name = "userId") String userIdToken) {
        List<LabelDetailsModel> labelList = labelService.setListOfLabel(userIdToken);

        return new ResponseEntity
                (new ResponseDTO("THE LABEL LIST ARE ", "200", labelList),
                        HttpStatus.OK);
    }

    @PutMapping("/update_label")
    public ResponseEntity updateLabel(@RequestHeader(name = "userId") String userIdToken,
                                      @RequestBody @Valid EditLabelDTO addLabelDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<ResponseDTO>(new ResponseDTO(bindingResult.getAllErrors().get(0).
                    getDefaultMessage(), "100", null),
                    HttpStatus.BAD_REQUEST);
        }

        LabelDetailsModel labelDetailsModel = labelService.updateLabel(userIdToken, addLabelDto);

        return new ResponseEntity
                (new ResponseDTO("THE LABEL UPDATED SUCCESSFULLY ", "200", labelDetailsModel),
                        HttpStatus.OK);

    }

    @DeleteMapping
    public ResponseEntity deleteLabel(@RequestHeader(name = "userId") String userIdToken,
                                      @RequestParam(name = "labelId") UUID labelId) {


        String labelDetailsModel = labelService.deleteLabelDetails(userIdToken, labelId);

        return new ResponseEntity
                (new ResponseDTO("THE LABEL DELETED SUCCESSFULLY ", "200", labelDetailsModel),
                        HttpStatus.OK);

    }


    @PostMapping("/labels_to_note")
    public ResponseEntity addLabeltoNote(@RequestHeader String token,
                                         @RequestParam UUID labelId,
                                         @RequestParam UUID noteId) {
        NoteDetailsModel noteDetailsModel = labelService.addLabelNote(token, labelId, noteId);

        return new ResponseEntity
                (new ResponseDTO("THE LABEL ADDED TO NOTE SUCCESSFULLY ",
                        "200",
                        noteDetailsModel),
                        HttpStatus.OK);

    }
    @PutMapping("/labels_to_note_new")
    public ResponseEntity addNewLabeltoNote(@RequestHeader String token,
                                            @RequestParam UUID noteId,
                                            @RequestBody @Valid LabelDTO addLabelDto,
                                            BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<ResponseDTO>(new ResponseDTO(bindingResult.getAllErrors().get(0).
                    getDefaultMessage(), "100", null),
                    HttpStatus.BAD_REQUEST);
        }

        NoteDetailsModel noteDetailsModel=labelService.addNewLabelToExistingNote(token,noteId,addLabelDto);

        return new ResponseEntity
                (new ResponseDTO("THE LABEL ADDED TO NOTE SUCCESSFULLY ",
                        "200",
                        noteDetailsModel),
                        HttpStatus.OK);

    }


    @GetMapping("/getting_all_label_notes")
    public ResponseEntity getLabelOfNotes(@RequestHeader(name = "userId") String userIdToken,
                                          @RequestParam UUID noteId) {

        List<LabelDetailsModel> labelList=labelService.getLabelByNotes(userIdToken,noteId);



        return new ResponseEntity
                (new ResponseDTO("THE LABEL LIST ARE ", "200", labelList),
                        HttpStatus.OK);

    }

    @PutMapping("/label/remove_label_from_Note")
    public ResponseEntity removeLabeltoNote(@RequestHeader String token,
                                            @RequestParam UUID labelId,
                                            @RequestParam UUID noteId){

        String deleteMessage=labelService.deleteLabelFromNote(token,labelId,noteId);

        return new ResponseEntity
                (new ResponseDTO("THE LABEL DELETION STATUS ", "200", deleteMessage),
                        HttpStatus.OK);

    }

}
