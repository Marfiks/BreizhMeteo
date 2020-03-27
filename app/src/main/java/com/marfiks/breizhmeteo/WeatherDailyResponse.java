package com.marfiks.breizhmeteo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherDailyResponse {

    @SerializedName("cod")
    public String cod;
    @SerializedName("message")
    public int message;
    @SerializedName("cnt")
    public int cnt;
    @SerializedName("list")
    public ArrayList<List> list = new ArrayList<List>();
    @SerializedName("city")
    public City city;
}

class City {
    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("coord")
    public Coord coord;
    @SerializedName("country")
    public String country;
}

class Coord {
    @SerializedName("lon")
    public double lon;
    @SerializedName("lat")
    public double lat;
}

class List {
    @SerializedName("dt")
    public int dt;
    @SerializedName("main")
    public Main main;
    @SerializedName("weather")
    public ArrayList<Weather> weather = new ArrayList<Weather>();
    @SerializedName("wind")
    public Wind wind;
    @SerializedName("dt_txt")
    public String dt_txt;
}

class Main{
    @SerializedName("temp_min")
    public double temp_min;
    @SerializedName("temp_max")
    public double temp_max;
    @SerializedName("pressure")
    public int pressure;
    @SerializedName("humidity")
    public int humidity;
}

class Wind{
    @SerializedName("speed")
    public float speed;
}

class Weather {
    @SerializedName("id")
    public int id;
    @SerializedName("main")
    public String main;
    @SerializedName("description")
    public String description;
    @SerializedName("icon")
    public String icon;
}
