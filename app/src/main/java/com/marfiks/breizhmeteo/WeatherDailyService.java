package com.marfiks.breizhmeteo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherDailyService {
    @GET("data/2.5/forecast?")
    Call<WeatherDailyResponse> getCurrentWeatherData(@Query("lang") String lang,@Query("units") String unit,@Query("id") int id, @Query("appid") String app_id);
}