package com.ap.porfolio.backend.controller;

import com.ap.porfolio.backend.model.Hard;
import com.ap.porfolio.backend.services.HardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/hardskills")
public class HardController {
    private final HardService hardService;

    public HardController(HardService hardService) {
        this.hardService = hardService;
    }

    @PostMapping("/{profileId}")
    public ResponseEntity<Hard> addHard(@PathVariable Long profileId, @RequestBody Hard hard){
        hardService.addHard(hard, profileId);
        return new ResponseEntity<>(hard, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Hard>> getHards(){
        List<Hard> hards = hardService.getHards();
        return new ResponseEntity<>(hards, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hard> updateHard(@PathVariable Long id, @RequestBody Hard updatedHard){
        Hard hard = hardService.updateHard(updatedHard, id);
        return new ResponseEntity<>(hard, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteHard(@PathVariable Long id){
        return hardService.deleteHard(id);
    }
}
