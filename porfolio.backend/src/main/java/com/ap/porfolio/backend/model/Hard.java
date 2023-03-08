package com.ap.porfolio.backend.model;

import jakarta.persistence.*;


@Entity
public class Hard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "skillname", nullable = false)
    private String skillname;

    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    public Hard() {}

    public Hard(String skillname) {
        this.skillname = skillname;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}