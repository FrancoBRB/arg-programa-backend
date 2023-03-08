package com.ap.porfolio.backend.repository;

import com.ap.porfolio.backend.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
