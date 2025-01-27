package com.example.test2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {

    interface RequestWeather {
        @GET("/weatherapi/nowcast/2.0/complete?lat=62.3955&lon=17.28611")
        Call<WeatherData> getWeatherData();
    }

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        Retrofit retrofit = ApiClient.getClient();
        RequestWeather requestWeather = retrofit.create(RequestWeather.class);

        requestWeather.getWeatherData().enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                if (response.isSuccessful() && response.body() != null) {
                    WeatherData weatherData = response.body();
                    if (weatherData.getProperties() != null && !weatherData.getProperties().getTimeseries().isEmpty()) {
                        WeatherData.TimeSeriesData firstTimeSeries = weatherData.getProperties().getTimeseries().get(0);
                        WeatherData.Details details = firstTimeSeries.getData().getInstant().getDetails();
                        double temp = details.getAir_temperature();
                        textView.setText("Air Tempera: " + temp + " °C");
                    } else {
                        textView.setText("No weather data available");
                    }
                } else {
                    try {
                        String errorBody = response.errorBody().string();
                        textView.setText("Response code: " + response.code() + "\nError: " + errorBody);
                    } catch (IOException e) {
                        e.printStackTrace();
                        textView.setText("Response code: " + response.code() + "\nError: Unable to read error body");
                    }
                }
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable error) {
                textView.setText(error.getMessage());
            }
        });
    }
}