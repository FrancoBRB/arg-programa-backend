package com.ap.porfolio.backend.services;

import com.ap.porfolio.backend.exceptions.ResourceNotFoundException;
import com.ap.porfolio.backend.model.Lang;
import com.ap.porfolio.backend.model.Profile;
import com.ap.porfolio.backend.repository.LangRepository;
import com.ap.porfolio.backend.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LangService {
    private final ProfileRepository profileRepository;
    private final LangRepository langRepository;

    @Autowired
    public LangService(ProfileRepository profileRepository, LangRepository langRepository) {
        this.profileRepository = profileRepository;
        this.langRepository = langRepository;
    }


    public Lang addLang(Lang lang, Long profileId){
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new ResourceNotFoundException("Id not found."));
        lang.setProfile(profile);
        return langRepository.save(lang);
    }

    public Lang getLang(Long id){
        return langRepository.getReferenceById(id);
    }

    public List<Lang> getLangs(){
        return langRepository.findAll();
    }

    public Lang updateLang(Lang updatedLang, Long id){
        Lang lang = langRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found."));
        lang.setLangName(updatedLang.getLangName());
        lang.setProfile(updatedLang.getProfile());
        lang.setPorcentage(updatedLang.getPorcentage());
        return updatedLang;
    }

    public String deleteLang(Long id){
        Optional<Lang> optionalLang = langRepository.findById(id);
        if (optionalLang.isPresent()) {
            langRepository.deleteById(id);
            return "Language deleted successfully.";
        } else {
            return "Id not found.";
        }
    }
}
