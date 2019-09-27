package com.diabetes.simpleserver.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Milamesher on 12.09.2019.
 */
@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public int getId() {
        return id;
    }


    @Basic
    @Column(name = "birthday")
    private String birthday;
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "risk")
    private String risk;
    public String getRisk() {
        return risk;
    }

    public void seRisk(String risk) {
        this.risk = risk;
    }

    @Basic
    @Column(name = "patientId")
    private Long patientId;
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    @Basic
    @Column(name = "slsId")
    private Long slsId;
    public Long getSlsId() {
        return slsId;
    }

    public void setSlsId(Long slsId) {
        this.slsId = slsId;
    }

    @Basic
    @Column(name = "createDate")
    private String createDate;
    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "bals")
    private Double bals;
    public Double getBals() {
        return bals;
    }

    public void setBals(Double bals) {
        this.bals = bals;
    }
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<com.diabetes.simpleserver.model.Parameter> par;

    public List<com.diabetes.simpleserver.model.Parameter> getPar() {
        return par;
    }

    public void setPar(List<com.diabetes.simpleserver.model.Parameter> par) {
        this.par = par;
    }

    public Card () {
        par = new ArrayList<>();
    }

    public void addParameter(Parameter p) {
        p.setCard(this);
        par.add(p);
    }
}