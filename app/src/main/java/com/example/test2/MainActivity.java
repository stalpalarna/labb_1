package com.example.test2;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    ImageView imageView;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.weatherImage);
        button = findViewById(R.id.refresh);

        // Fetch weather details
        WeatherDataManager.getWeatherSummary(new WeatherDataManager.WeatherSummaryCallback() {
            @Override
            public void onSuccess(WeatherSummary weatherSummary) {
                String symbolcode = weatherSummary.getWeatherSymbol();
                imageView.setImageResource(getSymbolImage(symbolcode));
                // Display the weather information
                textView.setText(
                            "Air Temperature: " + weatherSummary.getTemperature() + " °C\n" +
                                    "Wind Speed: " + weatherSummary.getWindSpeed() + " m/s\n" +
                                    "Wind Direction: " + weatherSummary.getWindDirection() + " \n"
                    );
                button.setVisibility(View.VISIBLE);

                button.setOnClickListener(click ->{

                });
            }


            @Override
            public void onError(String error) {
                // Handle error
                textView.setText("Error: " + error);
            }

            public int getSymbolImage(String symbolcode){
                return getResources().getIdentifier(symbolcode, "drawable", getPackageName());
            }
        });

    }
}