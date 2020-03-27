package com.marfiks.breizhmeteo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherDailyActivity extends AppCompatActivity {
    public static String BaseUrl = "https://api.openweathermap.org/";
    public static String app_id = "8c54ab7ce59d172b15a7c9c5c57f9e2d";
    RecyclerView recyclerView;
    WeatherDailyService service;
    private TextView ville;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_list);



        Bundle b = getIntent().getExtras();
        int id = b.getInt("id_ville");
        getCurrentData(this,id);
    }
    void getCurrentData(final Context context, int id){
        recyclerView = findViewById(R.id.weather_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(WeatherDailyService.class);
        Call<WeatherDailyResponse> call = service.getCurrentWeatherData("fr","metric",id, app_id);
        call.enqueue(new Callback<WeatherDailyResponse>() {
            @Override
            public void onResponse(@NonNull Call<WeatherDailyResponse> call, @NonNull Response<WeatherDailyResponse> response) {
                WeatherDailyResponse weatherResponse = response.body();
                assert weatherResponse != null;
                ville = findViewById(R.id.ville);
                ville.setText(weatherResponse.city.name);
                WeatherAdapter adapter = new WeatherAdapter(context, weatherResponse);
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<WeatherDailyResponse> call, Throwable t) {
                Log.d("ERROR", ""+t.getMessage());
            }
        });
    }
}