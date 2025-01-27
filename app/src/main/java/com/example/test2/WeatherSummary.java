package com.example.test2;

public class WeatherSummary {
    private double temperature;
    private double windSpeed;
    private String windDirection;
    private String weatherSymbol; // URL for weather-related image

    public WeatherSummary(double temperature, double windSpeed, String windDirection, String weatherSymbol) {
        this.temperature = temperature;
        this.windDirection = windDirection;
        this.weatherSymbol = weatherSymbol;
        this.windSpeed = windSpeed;
    }

    public double getTemperature() {
        return temperature;
    }
    public double getWindSpeed() {
        return windSpeed;
    }
    public String getWindDirection() {
        return windDirection;
    }

    public String getWeatherSymbol() {
        return weatherSymbol;
    }
}