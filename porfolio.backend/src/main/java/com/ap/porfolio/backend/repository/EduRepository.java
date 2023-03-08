package com.ap.porfolio.backend.repository;

import com.ap.porfolio.backend.model.Edu;
import com.ap.porfolio.backend.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EduRepository extends JpaRepository<Edu, Long> {
    List<Edu> findByProfile(Profile profile);
}
