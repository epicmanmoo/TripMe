package com.example.tripme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.nikartm.button.FitButton;

public class ContinuedSurveyActivity extends AppCompatActivity {

    private Spinner hSpinner, nSpinner, cSpinner, sSpinner;
    private FitButton bTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continued_survey);
        hSpinner = findViewById(R.id.historicSpinner);
        nSpinner = findViewById(R.id.natureSpinner);
        cSpinner = findViewById(R.id.cuisineSpinner);
        sSpinner = findViewById(R.id.strangerSpinner);
        bTrip = findViewById(R.id.bookTrip);
        bTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hSpinner.getSelectedItem().toString().equals("N/A") || nSpinner.getSelectedItem().toString().equals("N/A") || cSpinner.getSelectedItem().toString().equals("N/A") || sSpinner.getSelectedItem().toString().equals("N/A")){
                    Toast.makeText(getApplicationContext(), "Fill in fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent rActivity = new Intent(getApplicationContext(), TripOptionsActivity.class);
                    startActivity(rActivity);
                }
            }
        });
    }
}
