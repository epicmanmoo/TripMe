package com.example.tripme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.nikartm.button.FitButton;

public class HomeActivity extends AppCompatActivity {

    private FitButton bookTrip, accSetup, myTrip;
    private ProgressBar pBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bookTrip = findViewById(R.id.bookTrip);
        accSetup = findViewById(R.id.accountSetup);
        myTrip = findViewById(R.id.myTrips);
        bookTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tOPage = new Intent(getApplicationContext(), SurveyActivity.class);
                startActivity(tOPage);
            }
        });
        accSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "In Progress", Toast.LENGTH_LONG).show();
            }
        });
        myTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "No trips", Toast.LENGTH_LONG).show();
            }
        });
    }
}
