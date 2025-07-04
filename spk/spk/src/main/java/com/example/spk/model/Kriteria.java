package com.example.spk.model;

import jakarta.persistence.*;

@Entity(name = "kriteria")
public class Kriteria extends UserAudit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_kriteria")
    private String namaKriteria;

    @Column(name = "bobot_kriteria")
    private double bobotKriteria;

    // Getter & Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaKriteria() {
        return namaKriteria;
    }

    public void setNamaKriteria(String namaKriteria) {
        this.namaKriteria = namaKriteria;
    }

    public double getBobotKriteria() {
        return bobotKriteria;
    }

    public void setBobotKriteria(double bobot) {
        this.bobotKriteria = bobot;
    }
}
