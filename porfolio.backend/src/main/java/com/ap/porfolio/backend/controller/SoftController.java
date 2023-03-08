package com.ap.porfolio.backend.controller;

import com.ap.porfolio.backend.model.Soft;
import com.ap.porfolio.backend.services.SoftService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/softskills")
public class SoftController {
    private final SoftService softService;

    public SoftController(SoftService softService) {
        this.softService = softService;
    }


    @PostMapping("/{profileId}")
    public ResponseEntity<Soft> addSoft(@PathVariable Long profileId, @RequestBody Soft soft){
        softService.addSoft(soft, profileId);
        return new ResponseEntity<>(soft, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Soft>> getSofts(){
        List<Soft> softs = softService.getSofts();
        return new ResponseEntity<>(softs, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Soft> updateSoft(@PathVariable Long id, @RequestBody Soft updatedSoft){
        Soft soft = softService.updateSoft(updatedSoft, id);
        return new ResponseEntity<>(soft, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteSoft(@PathVariable Long id){
        return softService.deleteSoft(id);
    }
}
