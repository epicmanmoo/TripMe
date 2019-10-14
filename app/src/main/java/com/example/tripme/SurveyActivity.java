package com.example.tripme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.nikartm.button.FitButton;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SurveyActivity extends AppCompatActivity {

    private EditText days, hours, budget;
    private Spinner diet;
    private FitButton continueSurvey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        days = findViewById(R.id.days);
        hours = findViewById(R.id.hours);
        budget = findViewById(R.id.budget);
        continueSurvey = findViewById(R.id.continueSurvey);
        diet = findViewById(R.id.diet);

        continueSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(days.getText().toString().trim().equals("") || hours.getText().toString().trim().equals("") || budget.getText().toString().trim().equals("") || diet.getSelectedItem().toString().equals("No Selection")){
                    Toast.makeText(getApplicationContext(), "Fields cannot be blank", Toast.LENGTH_SHORT).show();
                }
                else if(!(Integer.parseInt(hours.getText().toString()) < 24)){
                    Toast.makeText(getApplicationContext(), "Hours must be less than 24", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent continueSurvey = new Intent(getApplicationContext(), ContinuedSurveyActivity.class);
                    startActivity(continueSurvey);
                }
            }
        });

    }
}
