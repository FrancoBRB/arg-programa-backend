package com.ap.porfolio.backend.repository;

import com.ap.porfolio.backend.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
