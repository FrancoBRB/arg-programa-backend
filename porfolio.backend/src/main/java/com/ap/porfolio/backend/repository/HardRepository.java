package com.ap.porfolio.backend.repository;

import com.ap.porfolio.backend.model.Hard;
import com.ap.porfolio.backend.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HardRepository extends JpaRepository<Hard, Long> {
    List<Hard> findByProfile(Profile profile);
}
