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

    @Column (name = "k1_hasil")
    private Double k1Hasil;

    @Column (name = "k2_hasil")
    private Double k2Hasil;

    @Column (name = "k3_hasil")
    private Double k3Hasil;

    @Column (name = "k4_hasil")
    private Double k4Hasil;

    @Column (name = "k5_hasil")
    private Double k5Hasil;


    // Getter & Setter

    public Double getK1Hasil() {
        return k1Hasil;
    }

    public void setK1Hasil(Double k1Hasil) {
        this.k1Hasil = k1Hasil;
    }

    public Double getK2Hasil() {
        return k2Hasil;
    }

    public void setK2Hasil(Double k2Hasil) {
        this.k2Hasil = k2Hasil;
    }

    public Double getK3Hasil() {
        return k3Hasil;
    }

    public void setK3Hasil(Double k3Hasil) {
        this.k3Hasil = k3Hasil;
    }

    public Double getK4Hasil() {
        return k4Hasil;
    }

    public void setK4Hasil(Double k4Hasil) {
        this.k4Hasil = k4Hasil;
    }

    public Double getK5Hasil() {
        return k5Hasil;
    }

    public void setK5Hasil(Double k5Hasil) {
        this.k5Hasil = k5Hasil;
    }

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
