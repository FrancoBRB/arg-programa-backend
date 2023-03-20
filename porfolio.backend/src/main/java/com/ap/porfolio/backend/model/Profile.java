package com.ap.porfolio.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cellphone", nullable = false)
    private String cellphone;

    @Column(name = "github", nullable = false)
    private String github;

    @Column(name = "linkedin", nullable = false)
    private String linkedin;

    @Column(name = "about", nullable = false, length = 1500)
    private String about;

    @Column(name = "photo")
    private String photo;

    @OneToMany(mappedBy = "id")
    private List<Hard> hardList;

    @OneToMany(mappedBy = "id")
    private List<Soft> softList;

    @OneToMany(mappedBy = "id")
    private List<Edu> eduList;

    @OneToMany(mappedBy = "id")
    private List<Project> projectList;

    @OneToMany(mappedBy = "id")
    private List<Lang> langList;


    public Profile() {}

    public Profile(String cellphone, String github, String linkedin, String about, String photo) {
        this.cellphone = cellphone;
        this.github = github;
        this.linkedin = linkedin;
        this.about = about;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }
}