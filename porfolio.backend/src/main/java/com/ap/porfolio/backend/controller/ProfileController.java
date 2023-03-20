package com.ap.porfolio.backend.controller;

import com.ap.porfolio.backend.model.Profile;
import com.ap.porfolio.backend.services.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/profiles")
@CrossOrigin(origins = "http://localhost:4200")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public ResponseEntity<List<Profile>> getProfiles(){
        List<Profile> profiles = profileService.getProfiles();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfile(@PathVariable("id") Long id){
        Profile profile = profileService.getProfile(id);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile, @PathVariable Long id){
        Profile updatedProfile = profileService.updateProfile(profile, id);
        return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
    }

    /* Los siguientes métodos son circunstanciales, ya que en el caso del post
       request se usarían la primera vez y luego a priori jamás se vuelven a
       tocar y el delete request en ningún caso se usaría. */

    @PostMapping
    public ResponseEntity<Profile> addProfile(@RequestBody Profile profile){
        Profile newProfile = profileService.addProfile(profile);
        return new ResponseEntity<>(newProfile, HttpStatus.OK);
    }

    /*
    @DeleteMapping("/{id}")
    public String deleteProfile(@PathVariable("id") Long id) {
        return profileService.deleteProfile(id);
    }
    */
}
