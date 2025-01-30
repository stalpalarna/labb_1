package com.example.test2;

import java.util.List;

public class WeatherData {
    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public static class Properties {
        private List<TimeSeriesData> timeseries;

        public List<TimeSeriesData> getTimeseries() {
            return timeseries;
        }

        public void setTimeseries(List<TimeSeriesData> timeseries) {
            this.timeseries = timeseries;
        }
    }

    public static class TimeSeriesData {
        private Data data;

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }
    }

    public static class Data {
        private Instant instant;
        private Next1Hours next_1_hours;

        public Instant getInstant() {
            return instant;
        }

        public void setInstant(Instant instant) {
            this.instant = instant;
        }

        public Next1Hours getNext_1_hours() {
            return next_1_hours;
        }

        public void setNext_1_hours(Next1Hours next_1_hours) {
            this.next_1_hours = next_1_hours;
        }
    }

    public static class Instant {
        private Details details;

        public Details getDetails() {
            return details;
        }

        public void setDetails(Details details) {
            this.details = details;
        }
    }

    public static class Next1Hours {
        private Summary summary;

        public Summary getSummary() {
            return summary;
        }

        public void setSummary(Summary summary) {
            this.summary = summary;
        }
    }

    public static class Summary {
        private String symbol_code;

        public String getSymbol_code() {
            return symbol_code;
        }

        public void setSymbol_code(String symbol_code) {
            this.symbol_code = symbol_code;
        }
    }

    public static class Details {
        private double air_temperature;
        private double wind_speed;
        private double relative_humidity;
        private double wind_from_direction;

        public double getAir_temperature() {
            return air_temperature;
        }

        public void setAir_temperature(double air_temperature) {
            this.air_temperature = air_temperature;
        }

        public double getWind_speed() {
            return wind_speed;
        }

        public void setWind_speed(double wind_speed) {
            this.wind_speed = wind_speed;
        }

        public double getRelative_humidity() {
            return relative_humidity;
        }

        public void setRelative_humidity(double relative_humidity) {
            this.relative_humidity = relative_humidity;
        }

        public double getWind_from_direction() {
            return wind_from_direction;
        }

        public void setWind_from_direction(double wind_from_direction) {
            this.wind_from_direction = wind_from_direction;
        }
    }
}