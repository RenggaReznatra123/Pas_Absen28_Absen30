package com.example.pas_absen28_absen30;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface APIservise {

    @GET("search_all_teams.php?l=English%20Premier%20League")
    Call<TeamResponse> getEnglishPremierleague(@Query("l") String league);

    @GET("/api/v1/json/3/eventsround.php?id=4335&r=36&s=2024-2025")
    Call<JadwalResponse> getJadwalLaliga(@Query("j") String jadwal1);

}