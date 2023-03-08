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

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

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

    public Profile(String email, String password, String about, String photo) {
        this.email = email;
        this.password = password;
        this.about = about;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

}