package com.example.spk.model;

import jakarta.persistence.*;

@Entity(name = "penilaian")
public class Penilaian extends UserAudit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long alternatif_id;

    @Column (name = "k1")
    private double k1;

    @Column (name = "k2")
    private double k2;

    @Column (name = "k3")
    private double k3;

    @Column (name = "k4")
    private double k4;

    @Column (name = "k5")
    private double k5;

    // Getter & Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAlternatif_id() {
        return alternatif_id;
    }

    public void setAlternatif_id(Long alternatif_id) {
        this.alternatif_id = alternatif_id;
    }

    public double getK1() {
        return k1;
    }

    public void setK1(double k1) {
        this.k1 = k1;
    }

    public double getK2() {
        return k2;
    }

    public void setK2(double k2) {
        this.k2 = k2;
    }

    public double getK3() {
        return k3;
    }

    public void setK3(double k3) {
        this.k3 = k3;
    }

    public double getK4() {
        return k4;
    }

    public void setK4(double k4) {
        this.k4 = k4;
    }

    public double getK5() {
        return k5;
    }

    public void setK5(double k5) {
        this.k5 = k5;
    }
}
