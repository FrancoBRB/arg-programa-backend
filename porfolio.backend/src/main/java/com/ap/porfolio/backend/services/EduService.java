package com.ap.porfolio.backend.services;

import com.ap.porfolio.backend.exceptions.ResourceNotFoundException;
import com.ap.porfolio.backend.model.Edu;
import com.ap.porfolio.backend.model.Profile;
import com.ap.porfolio.backend.repository.EduRepository;
import com.ap.porfolio.backend.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EduService {

    private final ProfileRepository profileRepository;
    private final EduRepository eduRepository;

    @Autowired
    public EduService(ProfileService profileService, ProfileRepository profileRepository, EduRepository eduRepository) {
        this.profileRepository = profileRepository;
        this.eduRepository = eduRepository;
    }

    public Edu addEdu(Edu edu, Long profileId){
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new ResourceNotFoundException("Id not found."));
        edu.setProfile(profile);
        return eduRepository.save(edu);
    }

    public List<Edu> getEdus(){
        return eduRepository.findAll();
    }

    public List<Edu> getEdusByProfileId(Long profileId){
        Profile profile = profileRepository.findById(profileId).orElseThrow(() -> new ResourceNotFoundException("Id not found."));
        return eduRepository.findByProfile(profile);
    }

    public Edu updateEdu(Edu updatedEdu, Long id){
        Edu edu = eduRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found."));
        edu.setCareer(updatedEdu.getCareer());
        edu.setImg(updatedEdu.getImg());
        edu.setEstablishment(updatedEdu.getEstablishment());
        edu.setDateFin(updatedEdu.getDateFin());
        edu.setDateIni(updatedEdu.getDateIni());
        return edu;
    }

    public String deleteEdu(Long id){
        Optional<Edu> optionalEdu = eduRepository.findById(id);
        if (optionalEdu.isPresent()) {
            eduRepository.deleteById(id);
            return "Edu deleted successfully.";
        } else {
            return "Id not found.";
        }
    }
}