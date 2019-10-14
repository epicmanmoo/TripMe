package com.example.tripme;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.nikartm.button.FitButton;

import java.util.ArrayList;
import java.util.List;

import static com.example.tripme.TripMaker.buildDay;

public class ResultsActivity extends AppCompatActivity {

    private TextView loc, event;
    private ImageView pic;
    private FitButton change;
    private ImageView pics;
    static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String toLoc = getIntent().getExtras().getString("toLocation");
        loc = findViewById(R.id.location);
        change = findViewById(R.id.changeEverything);
        event = findViewById(R.id.event);
        pics = findViewById(R.id.picture);
        final List<Events> day = buildDay(toLoc);


        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count >= day.size()){
                    count = 0;
                } else {
                    loc.setText(day.get(count).getPlace());
                    event.setText(day.get(count).getType());
                    switch(day.get(count).getType()){
                        case "Hotels":
                            pics.setImageResource(R.drawable.hotel);
                            break;
                        case "Restaurants":
                            pics.setImageResource(R.drawable.restaurant);
                            break;
                        case "Transit":
                            Toast.makeText(getApplicationContext(), "Duration: " + day.get(count).getUberDuration() + " minutes", Toast.LENGTH_LONG).show();
                            pics.setImageResource(R.drawable.lyft);
                            break;
                        case "Attractions":
                            pics.setImageResource(R.drawable.destinations);
                    }


                    count++;
                }
            }
        });
    }
}
