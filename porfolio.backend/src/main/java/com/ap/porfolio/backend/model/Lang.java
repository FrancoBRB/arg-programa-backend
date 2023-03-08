package com.ap.porfolio.backend.model;

import jakarta.persistence.*;

@Entity
public class Lang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lang-name", nullable = false)
    private String langName;

    @Column(name = "porcentage", nullable = false)
    private Long porcentage;

    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    public Lang() {}

    public Lang(String langName, Long porcentage) {
        this.langName = langName;
        this.porcentage = porcentage;
    }

    public Long getId() {
        return id;
    }

    public String getLangName() {
        return langName;
    }

    public void setLangName(String langName) {
        this.langName = langName;
    }

    public Long getPorcentage() {
        return porcentage;
    }

    public void setPorcentage(Long porcentage) {
        this.porcentage = porcentage;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
