package com.example.spk.payload.response;

public class KriteriaResponse {

    private Long id;
    private String namaKriteria;
    private Double bobotKriteria;

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

    public Double getBobotKriteria() {
        return bobotKriteria;
    }

    public void setBobotKriteria(Double bobotKriteria) {
        this.bobotKriteria = bobotKriteria;
    }
}
