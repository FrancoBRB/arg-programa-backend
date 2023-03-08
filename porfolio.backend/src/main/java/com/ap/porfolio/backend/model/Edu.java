package com.ap.porfolio.backend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Edu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "establishment", nullable = false)
    private String establishment;

    @Column(name = "career", nullable = false)
    private String career;

    @Column(name= "date-ini", nullable = false)
    private Date dateIni;

    @Column(name= "date-fin", nullable = false)
    private Date dateFin;

    @Column(name= "img", nullable = false)
    private String img;

    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    public Edu() {}

    public Edu(String establishment, String career, Date dateIni, Date dateFin, String img) {
        this.establishment = establishment;
        this.career = career;
        this.dateIni = dateIni;
        this.dateFin = dateFin;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public String getEstablishment() {
        return establishment;
    }

    public void setEstablishment(String establishment) {
        this.establishment = establishment;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public Date getDateIni() {
        return dateIni;
    }

    public void setDateIni(Date dateIni) {
        this.dateIni = dateIni;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
