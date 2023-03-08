package com.ap.porfolio.backend.model;

import jakarta.persistence.*;


@Entity
public class Soft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "skillname", nullable = false)
    private String skillname;

    @Column(name = "porcentage", nullable = false)
    private Long porcentage;

    public Soft() {}

    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    public Soft(String skillname, Long porcentage) {
        this.skillname = skillname;
        this.porcentage = porcentage;
    }

    public Long getId() {
        return id;
    }

    public String getSkillname() {
        return skillname;
    }

    public void setSkillname(String skillname) {
        this.skillname = skillname;
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
