package com.ap.porfolio.backend.repository;

import com.ap.porfolio.backend.model.Profile;
import com.ap.porfolio.backend.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByProfile(Profile profile);
}
