package com.ap.porfolio.backend.controller;

import com.ap.porfolio.backend.model.Lang;
import com.ap.porfolio.backend.services.LangService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/languages")
public class LangController {
    private final LangService langService;

    public LangController(LangService langService) {
        this.langService = langService;
    }


    @PostMapping("/{profileId}")
    public ResponseEntity<Lang> addLang(@PathVariable Long profileId, @RequestBody Lang lang){
        langService.addLang(lang, profileId);
        return new ResponseEntity<>(lang, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Lang>> getLangs(){
        List<Lang> langs = langService.getLangs();
        return new ResponseEntity<>(langs, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lang> updateLang(@PathVariable Long id, @RequestBody Lang updatedLang){
        Lang lang = langService.updateLang(updatedLang, id);
        return new ResponseEntity<>(lang, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteLang(@PathVariable Long id){
        return langService.deleteLang(id);
    }
}

