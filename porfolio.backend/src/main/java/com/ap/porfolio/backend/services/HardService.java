package com.ap.porfolio.backend.services;

import com.ap.porfolio.backend.exceptions.ResourceNotFoundException;
import com.ap.porfolio.backend.model.Hard;
import com.ap.porfolio.backend.model.Profile;
import com.ap.porfolio.backend.repository.HardRepository;
import com.ap.porfolio.backend.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HardService {
    private final ProfileRepository profileRepository;
    private final HardRepository hardRepository;

    @Autowired
    public HardService(ProfileRepository profileRepository, HardRepository hardRepository) {
        this.profileRepository = profileRepository;
        this.hardRepository = hardRepository;
    }


    public Hard addHard(Hard hard, Long profileId){
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new ResourceNotFoundException("Id not found."));
        hard.setProfile(profile);
        return hardRepository.save(hard);
    }

    public Hard getHard(Long id){
        return hardRepository.getReferenceById(id);
    }

    public List<Hard> getHards(){
        return hardRepository.findAll();
    }

    public List<Hard> getHardsByProfileId(Long profileId){
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new ResourceNotFoundException("Id not found."));
        return hardRepository.findByProfile(profile);
    }

    public Hard updateHard(Hard updatedHard, Long id){
        Hard hard = hardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found."));
        hard.setSkillname(updatedHard.getSkillname());
        return hard;
    }

    public String deleteHard(Long id){
        Optional<Hard> optionalHard = hardRepository.findById(id);
        if (optionalHard.isPresent()) {
            hardRepository.deleteById(id);
            return "Hardskill deleted successfully.";
        } else {
            return "Id not found.";
        }
    }
}