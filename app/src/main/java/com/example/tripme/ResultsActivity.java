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
import static com.example.tripme.BookTripActivity.pd;

public class ResultsActivity extends AppCompatActivity {

    private TextView loc, event, dur;
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
        dur = findViewById(R.id.duration);
        try {
            final List<Events> day = buildDay(toLoc);
            pd.dismiss();
            change.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (count >= day.size()) {
                        count = 0;
                    } else {
                        dur.setVisibility(View.INVISIBLE);
                        loc.setText(day.get(count).getPlace());
                        event.setText(day.get(count).getType());
                        switch (day.get(count).getType()) {
                            case "Hotels":
                                pics.setImageResource(R.drawable.hotel);
                                break;
                            case "Restaurants":
                                pics.setImageResource(R.drawable.restaurant);
                                break;
                            case "Transit":
                                //Toast.makeText(getApplicationContext(), "Duration: " + day.get(count).getUberDuration() + " minutes", Toast.LENGTH_LONG).show();
                                dur.setVisibility(View.VISIBLE);
                                dur.setText("Duation: " + day.get(count).getUberDuration() + " minutes");
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
        catch(NullPointerException e){
            pd.dismiss();
            Toast.makeText(getApplicationContext(), "Please try a different location!", Toast.LENGTH_LONG).show();
            finish();
        }
    }
}
