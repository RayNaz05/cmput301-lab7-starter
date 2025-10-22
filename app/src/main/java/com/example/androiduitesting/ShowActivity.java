package com.example.androiduitesting;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    public static final String EXTRA_CITY = "extra_city";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        // get the city name sent from MainActivity
        Intent intent = getIntent();
        String cityName = intent.getStringExtra(EXTRA_CITY);

        // find the TextView and display the name
        TextView cityText = findViewById(R.id.text_city_name);
        cityText.setText(cityName);

        // back button logic
        Button backButton = findViewById(R.id.button_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // closes this activity and goes back
            }
        });
    }
}
