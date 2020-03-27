package com.marfiks.breizhmeteo;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    Context context;
    WeatherDailyResponse weatherDailyResponse;

    public WeatherAdapter(Context context, WeatherDailyResponse weatherDailyResponse){
        this.context = context;
        this.weatherDailyResponse = weatherDailyResponse;
    }

    @Override
    public WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.weather, parent, false);
        return new WeatherViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WeatherAdapter.WeatherViewHolder holder, int position) {
        Picasso.get().load("https://openweathermap.org/img/w/"+weatherDailyResponse.list.get(position).weather.get(0).icon+".png").into(holder.micon);
        String[] dates = weatherDailyResponse.list.get(position).dt_txt.split("-");
        String[] date2 = dates[2].split(" ");

        String date = date2[0]+" "+dates[1]+" "+dates[0];
        holder.mdate.setText(date);
        holder.mdescription.setText(weatherDailyResponse.list.get(position).weather.get(0).description);
        holder.mhumi.setText(("humidité : "+weatherDailyResponse.list.get(position).main.humidity+"%"));
        holder.mpressure.setText("pression : "+weatherDailyResponse.list.get(position).main.pressure+" hpa");
        holder.mtemp_max.setText(weatherDailyResponse.list.get(position).main.temp_max+"°C");
        holder.mtemp_min.setText(weatherDailyResponse.list.get(position).main.temp_min+"°C");
        holder.mvents.setText("vent : "+weatherDailyResponse.list.get(position).wind.speed+" m/s");

    }

    @Override
    public int getItemCount() {
        return weatherDailyResponse.list.size();
    }


    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        private TextView mdate;
        private ImageView micon;
        private TextView mtemp_max;
        private TextView mtemp_min;
        private TextView mdescription;
        private TextView mvents;
        private TextView mhumi;
        private TextView mpressure;

        public WeatherViewHolder(final View itemView) {
            super(itemView);

            mdate = itemView.findViewById(R.id.date);
            mdescription = itemView.findViewById(R.id.description);
            micon = itemView.findViewById(R.id.icon);
            mtemp_max = itemView.findViewById(R.id.tempmax);
            mtemp_min = itemView.findViewById(R.id.tempmin);
            mvents = itemView.findViewById(R.id.vents);
            mhumi = itemView.findViewById(R.id.humidité);
            mpressure = itemView.findViewById(R.id.pressure);
        }
    }
}
