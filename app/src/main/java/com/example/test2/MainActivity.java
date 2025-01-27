package com.example.test2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        // Fetch weather details
        WeatherDataManager.getWeatherSummary(new WeatherDataManager.WeatherSummaryCallback() {
            @Override
            public void onSuccess(WeatherSummary weatherSummary) {
                    // Display the weather information
                    textView.setText(
                            "Air Temperature: " + weatherSummary.getTemperature() + " °C\n" +
                                    "Wind Speed: " + weatherSummary.getWindSpeed() + " m/s\n" +
                                    "Wind Direction: " + weatherSummary.getWindDirection() + " \n" + weatherSummary.getWeatherSymbol()
                    );
                }


            @Override
            public void onError(String error) {
                // Handle error
            textView.setText("Error: " + error);
            }
        });

    }
}