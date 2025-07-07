package com.example.spk.model;

import jakarta.persistence.*;

@Entity(name = "penilaian")
public class Penilaian extends UserAudit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "alternatif_id")
    private Long alternatifId;

    @Column (name = "k1")
    private Integer k1;

    @Column (name = "k2")
    private Integer k2;

    @Column (name = "k3")
    private Integer k3;

    @Column (name = "k4")
    private Integer k4;

    @Column (name = "k5")
    private Integer k5;

    // Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAlternatifId() {
        return alternatifId;
    }

    public void setAlternatifId(Long alternatifId) {
        this.alternatifId = alternatifId;
    }

    public Integer getK1() {
        return k1;
    }

    public void setK1(Integer k1) {
        this.k1 = k1;
    }

    public Integer getK2() {
        return k2;
    }

    public void setK2(Integer k2) {
        this.k2 = k2;
    }

    public Integer getK3() {
        return k3;
    }

    public void setK3(Integer k3) {
        this.k3 = k3;
    }

    public Integer getK4() {
        return k4;
    }

    public void setK4(Integer k4) {
        this.k4 = k4;
    }

    public Integer getK5() {
        return k5;
    }

    public void setK5(Integer k5) {
        this.k5 = k5;
    }
}
