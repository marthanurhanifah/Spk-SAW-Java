package com.example.spk.enumeration;

public enum HttpStatusCustom {
    NIK_SUDAH_ADA(601, "Nik Sudah Ada"),
    ID_TIDAK_DITEMUKAN(602, "Id Tidak Ditemukan");

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
