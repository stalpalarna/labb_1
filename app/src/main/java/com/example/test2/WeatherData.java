package com.example.test2;
import java.util.List;

public class WeatherData {
    private String type;
    private GeometryData geometry;
    private PropertiesData properties;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public GeometryData getGeometry() {
        return geometry;
    }

    public void setGeometry(GeometryData geometry) {
        this.geometry = geometry;
    }

    public PropertiesData getProperties() {
        return properties;
    }

    public void setProperties(PropertiesData properties) {
        this.properties = properties;
    }

    public static class GeometryData {
        private String type;
        private double[] coordinates;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double[] getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(double[] coordinates) {
            this.coordinates = coordinates;
        }
    }

    public static class PropertiesData {
        private MetaData meta;
        private List<TimeSeriesData> timeseries;

        public MetaData getMeta() {
            return meta;
        }

        public void setMeta(MetaData meta) {
            this.meta = meta;
        }

        public List<TimeSeriesData> getTimeseries() {
            return timeseries;
        }

        public void setTimeseries(List<TimeSeriesData> timeseries) {
            this.timeseries = timeseries;
        }
    }

    public static class MetaData {
        private String updated_at;
        private UnitsData units;
        private String radar_coverage;

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public UnitsData getUnits() {
            return units;
        }

        public void setUnits(UnitsData units) {
            this.units = units;
        }

        public String getRadar_coverage() {
            return radar_coverage;
        }

        public void setRadar_coverage(String radar_coverage) {
            this.radar_coverage = radar_coverage;
        }
    }

    public static class UnitsData {
        private String air_temperature;
        private String precipitation_amount;
        private String precipitation_rate;
        private String relative_humidity;
        private String wind_from_direction;
        private String wind_speed;
        private String wind_speed_of_gust;

        public String getAir_temperature() {
            return air_temperature;
        }

        public void setAir_temperature(String air_temperature) {
            this.air_temperature = air_temperature;
        }

        public String getPrecipitation_amount() {
            return precipitation_amount;
        }

        public void setPrecipitation_amount(String precipitation_amount) {
            this.precipitation_amount = precipitation_amount;
        }

        public String getPrecipitation_rate() {
            return precipitation_rate;
        }

        public void setPrecipitation_rate(String precipitation_rate) {
            this.precipitation_rate = precipitation_rate;
        }

        public String getRelative_humidity() {
            return relative_humidity;
        }

        public void setRelative_humidity(String relative_humidity) {
            this.relative_humidity = relative_humidity;
        }

        public String getWind_from_direction() {
            return wind_from_direction;
        }

        public void setWind_from_direction(String wind_from_direction) {
            this.wind_from_direction = wind_from_direction;
        }

        public String getWind_speed() {
            return wind_speed;
        }

        public void setWind_speed(String wind_speed) {
            this.wind_speed = wind_speed;
        }

        public String getWind_speed_of_gust() {
            return wind_speed_of_gust;
        }

        public void setWind_speed_of_gust(String wind_speed_of_gust) {
            this.wind_speed_of_gust = wind_speed_of_gust;
        }
    }

    public static class TimeSeriesData {
        private String time;
        private Data data;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

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
        private Details details;

        public Summary getSummary() {
            return summary;
        }

        public void setSummary(Summary summary) {
            this.summary = summary;
        }

        public Details getDetails() {
            return details;
        }

        public void setDetails(Details details) {
            this.details = details;
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
        private double precipitation_rate;
        private double relative_humidity;
        private double wind_from_direction;
        private double wind_speed;
        private double wind_speed_of_gust;
        private double precipitation_amount;

        public double getAir_temperature() {
            return air_temperature;
        }

        public void setAir_temperature(double air_temperature) {
            this.air_temperature = air_temperature;
        }

        public double getPrecipitation_rate() {
            return precipitation_rate;
        }

        public void setPrecipitation_rate(double precipitation_rate) {
            this.precipitation_rate = precipitation_rate;
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

        public double getWind_speed() {
            return wind_speed;
        }

        public void setWind_speed(double wind_speed) {
            this.wind_speed = wind_speed;
        }

        public double getWind_speed_of_gust() {
            return wind_speed_of_gust;
        }

        public void setWind_speed_of_gust(double wind_speed_of_gust) {
            this.wind_speed_of_gust = wind_speed_of_gust;
        }

        public double getPrecipitation_amount() {
            return precipitation_amount;
        }

        public void setPrecipitation_amount(double precipitation_amount) {
            this.precipitation_amount = precipitation_amount;
        }
    }
}