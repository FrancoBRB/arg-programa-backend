package com.ap.porfolio.backend.services;


import com.ap.porfolio.backend.exceptions.ResourceNotFoundException;
import com.ap.porfolio.backend.model.Profile;
import com.ap.porfolio.backend.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProfileService {
    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile addProfile(Profile profile){
        String encodedPassword = new BCryptPasswordEncoder().encode(profile.getPassword());
        profile.setPassword(encodedPassword);
        return profileRepository.save(profile);
    }

    public Profile getProfile(Long id){
        return profileRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found."));
    }

    public Profile getProfileByEmail(String email){
        return profileRepository.findByEmail(email);
    }

    public List<Profile> getProfiles(){
        return profileRepository.findAll();
    }

    public Profile updateProfile(Profile updatedProfile, Long id){
        Profile profile = profileRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found."));
        profile.setAbout(updatedProfile.getAbout());
        profile.setEmail(updatedProfile.getEmail());
        profile.setPhoto(updatedProfile.getPhoto());
        profile.setPassword(updatedProfile.getPassword());
        return profile;
    }
    /*
    public String deleteProfile(Long id) {
        Optional<Profile> optionalProfile = profileRepository.findById(id);
        if (optionalProfile.isPresent()) {
            profileRepository.deleteById(id);
            return "Profile deleted successfully.";
        } else {
            return "Id not found.";
        }
    }
    */
}
