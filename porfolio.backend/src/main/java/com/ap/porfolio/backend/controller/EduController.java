package com.ap.porfolio.backend.controller;

import com.ap.porfolio.backend.model.Edu;
import com.ap.porfolio.backend.services.EduService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/edu")
public class EduController {
    private final EduService eduService;

    public EduController(EduService eduService) {
        this.eduService = eduService;
    }

    @PostMapping("/{profileId}")
    public ResponseEntity<Edu> addEdu(@PathVariable Long profileId, @RequestBody Edu edu){
        eduService.addEdu(edu, profileId);
        return new ResponseEntity<>(edu, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Edu>> getEdus(){
        List<Edu> edus = eduService.getEdus();
        return new ResponseEntity<>(edus, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Edu> updateEdu(@PathVariable Long id, @RequestBody Edu updatedEdu){
        Edu edu = eduService.updateEdu(updatedEdu, id);
        return new ResponseEntity<>(edu, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteEdu(@PathVariable Long id){
        return eduService.deleteEdu(id);
    }
}
