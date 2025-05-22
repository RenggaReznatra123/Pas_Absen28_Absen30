package com.example.pas_absen28_absen30;

import com.google.gson.annotations.SerializedName;
public class JadwalModel {



    @SerializedName("strEvent")
    private String strEvent;

    @SerializedName("strPoster")
    private String strPoster;

    @SerializedName("strHomeTeam")
    private String strHomeTeam;

    @SerializedName("strAwayTeam")
    private String strAwayTeam;

    @SerializedName("strHomeTeamBadge")
    private String strHomeTeamBadge;

    @SerializedName("strAwayTeamBadge")
    private String strAwayTeamBadge;

    @SerializedName("intHomeScore")
    private String intHomeScore;

    @SerializedName("intAwayScore")
    private String intAwayScore;

    @SerializedName("dateEventLocal")
    private String dateEventLocal;

    @SerializedName("strTimeLocal")
    private String strTimeLocal;

    JadwalModel(String strEvent, String strPoster,String strHomeTeam,String strAwayTeam,String strHomeTeamBadge,String strAwayTeamBadge,String intHomeScore,String intAwayScore,String dateEventLocal, String strTimeLocal){
        this.strEvent = strEvent;
        this.strPoster = strPoster;
        this.strHomeTeam = strHomeTeam;
        this.strAwayTeam = strAwayTeam;
        this.strHomeTeamBadge = strHomeTeamBadge;
        this.strAwayTeamBadge = strAwayTeamBadge;
        this.intHomeScore = intHomeScore;
        this.intAwayScore = intAwayScore;
        this.dateEventLocal = dateEventLocal;
        this.strTimeLocal = strTimeLocal;
    }

    public String getStrEvent() {
        return strEvent;
    }

    public String getStrPoster() {
        return strPoster;
    }

    public String getStrHomeTeam() {
        return strHomeTeam;
    }

    public String getStrAwayTeam() {
        return strAwayTeam;
    }

    public String getStrHomeTeamBadge() {
        return strHomeTeamBadge;
    }

    public String getStrAwayTeamBadge() {
        return strAwayTeamBadge;
    }

    public String getIntHomeScore() {
        return intHomeScore;
    }

    public String getIntAwayScore() {
        return intAwayScore;
    }

    public String getDateEventLocal() {
        return dateEventLocal;
    }

    public String getStrTimeLocal() {
        return strTimeLocal;
    }
}
