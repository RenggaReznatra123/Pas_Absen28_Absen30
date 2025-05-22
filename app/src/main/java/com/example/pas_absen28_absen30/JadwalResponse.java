package com.example.pas_absen28_absen30;

import com.google.gson.annotations.SerializedName;

import java.util.List;
public class JadwalResponse {
    @SerializedName("events")
    private List<JadwalModel> jadwal;

    public List<JadwalModel> getJadwalLaliga() {
        return jadwal;
    }
}