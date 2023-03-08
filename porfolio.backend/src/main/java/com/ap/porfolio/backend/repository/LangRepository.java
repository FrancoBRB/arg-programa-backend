package com.ap.porfolio.backend.repository;

import com.ap.porfolio.backend.model.Lang;
import com.ap.porfolio.backend.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LangRepository extends JpaRepository<Lang, Long> {
    List<Lang> findByProfile(Profile profile);
}
