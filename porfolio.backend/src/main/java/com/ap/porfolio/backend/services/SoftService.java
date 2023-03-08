package com.ap.porfolio.backend.services;

import com.ap.porfolio.backend.exceptions.ResourceNotFoundException;
import com.ap.porfolio.backend.model.Profile;
import com.ap.porfolio.backend.model.Soft;
import com.ap.porfolio.backend.repository.ProfileRepository;
import com.ap.porfolio.backend.repository.SoftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SoftService {
    private final ProfileRepository profileRepository;
    private final SoftRepository softRepository;

    @Autowired
    public SoftService(ProfileRepository profileRepository, SoftRepository softRepository) {
        this.profileRepository = profileRepository;
        this.softRepository = softRepository;
    }

    public Soft addSoft(Soft soft, Long profileId){
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new ResourceNotFoundException("Id not found."));
        soft.setProfile(profile);
        return softRepository.save(soft);
    }

    public Soft getSoft(Long id){
        return softRepository.getReferenceById(id);
    }

    public List<Soft> getSofts(){
        return softRepository.findAll();
    }

    public List<Soft> getSoftsByProfileId(Long profileId){
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new ResourceNotFoundException("Id not found."));
        return softRepository.findByProfile(profile);
    }

    public Soft updateSoft(Soft updatedSoft, Long id){
        Soft soft = softRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found."));
        soft.setPorcentage(updatedSoft.getPorcentage());
        soft.setSkillname(updatedSoft.getSkillname());
        return soft;
    }

    public String deleteSoft(Long id){
        Optional<Soft> optionalSoft = softRepository.findById(id);
        if (optionalSoft.isPresent()) {
            softRepository.deleteById(id);
            return "Softskill deleted successfully.";
        } else {
            return "Id not found.";
        }
    }
}
