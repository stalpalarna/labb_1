package com.example.test2;

import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public class WeatherDataManager {

    // Retrofit interface for making the API call
    interface RequestWeather {
        @GET("/weatherapi/nowcast/2.0/complete?lat=62.3955&lon=17.28611")
        Call<WeatherData> getWeatherData();
    }

    // Custom callback interface to handle the success and error cases
    public interface WeatherSummaryCallback {
        void onSuccess(WeatherSummary weatherSummary); // Called on successful response
        void onError(String error); // Called on error
    }


    // Method to fetch weather details using the Retrofit interface
    public static void getWeatherSummary(WeatherSummaryCallback callback) {
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

                        // Extract temperature
                        double temperature = details.getAir_temperature();
                        double windSpeed = details.getWind_speed();
                        // Extract wind direction
                        double windDirectionValue = details.getWind_from_direction();
                        String windDirection = getWindDirection(windDirectionValue);

                        // Example: Assign a weather image URL based on conditions
                        String imageUrl = firstTimeSeries.getData().getNext_1_hours().getSummary().getSymbol_code();

                        // Create a WeatherSummary object
                        WeatherSummary summary = new WeatherSummary(temperature, windSpeed, windDirection, imageUrl);

                        // Pass it to the callback
                        callback.onSuccess(summary);
                    } else {
                        callback.onError("No weather data available");
                    }
                } else {
                    try {
                        String errorBody = response.errorBody().string();
                        callback.onError("Response code: " + response.code() + "\nError: " + errorBody);
                    } catch (IOException e) {
                        callback.onError("Response code: " + response.code() + "\nError: Unable to read error body");
                    }
                }
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
    // Helper function to determine wind direction as a string
    private static String getWindDirection(double windDirection) {
        if (windDirection >= 315 || windDirection < 45) {
            return "north";
        } else if (windDirection >= 45 && windDirection < 135) {
            return "east";
        } else if (windDirection >= 135 && windDirection < 225) {
            return "south";
        } else {
            return "west";
        }
    }
}