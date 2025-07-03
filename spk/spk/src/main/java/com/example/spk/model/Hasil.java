package com.example.spk.model;

import jakarta.persistence.*;

@Entity(name = "hasil")
public class Hasil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "batas_bawah")
    private String batasBawah;

    @Column(name = "batas_atas")
    private String batasAtas;

    @Column(name = "hasil")
    private String hasil;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBatasBawah() {
        return batasBawah;
    }

    public void setBatasBawah(String batasBawah) {
        this.batasBawah = batasBawah;
    }

    public String getBatasAtas() {
        return batasAtas;
    }

    public void setBatasAtas(String batasAtas) {
        this.batasAtas = batasAtas;
    }

    public String getHasil() {
        return hasil;
    }

    public void setHasil(String hasil) {
        this.hasil = hasil;
    }

}