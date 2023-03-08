package com.ap.porfolio.backend.repository;

import com.ap.porfolio.backend.model.Profile;
import com.ap.porfolio.backend.model.Soft;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SoftRepository extends JpaRepository<Soft, Long> {
    List<Soft> findByProfile(Profile profile);
}
