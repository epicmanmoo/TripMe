package com.example.tripme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.github.nikartm.button.FitButton;

public class TripOptionsActivity extends AppCompatActivity {

    private FitButton fTrip, cTrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_options);
        fTrip = findViewById(R.id.friendsTrip);
        cTrip = findViewById(R.id.createTrip);
        fTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent friendPage = new Intent(getApplicationContext(), FriendActivity.class);
                startActivity(friendPage);
            }
        });
        cTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createPage = new Intent(getApplicationContext(), BookTripActivity.class);
                startActivity(createPage);
            }
        });
    }
}
