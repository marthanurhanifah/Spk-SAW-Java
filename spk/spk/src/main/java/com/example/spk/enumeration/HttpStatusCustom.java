package com.example.spk.enumeration;

public enum HttpStatusCustom {
    NIK_SUDAH_ADA(601, "Nik Sudah Ada"),
    ID_TIDAK_DITEMUKAN(602, "Id Tidak Ditemukan"),
    NAMA_KRITERIA_SUDAH_ADA(603, "Nama kriteria Sudah Ada"),
    ID_ALTERNATIF_SUDAH_ADA(604, "Id Alternatif Sudah Ada"),
    NIK_TIDAK_BOLEH_KOSONG(605,"ID Tidak Boleh Kosong"),
    NAMA_KRITERIA_TIDAK_BOLEH_KOSONG(606,"Nama Kriteria Tidak Ditemukan"),
    ALTERNATIF_ID_TIDAK_BOLEH_KOSONG(607,"Alternatif Id TIdak Boleh Kosong");

    private final int value;
    private final String reasonPhrase;

    HttpStatusCustom(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int getValue() {
        return value;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }
}
