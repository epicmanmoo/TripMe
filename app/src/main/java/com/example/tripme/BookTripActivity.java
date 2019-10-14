package com.example.tripme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.github.nikartm.button.FitButton;

public class BookTripActivity extends AppCompatActivity {

    private FitButton toSurvey;
    private EditText toL;
    public static ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_trip);
        toSurvey = findViewById(R.id.toSurvey);
        toL = findViewById(R.id.toLocation);
        toSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toL.getText().toString().trim().equals("")){
                    Toast.makeText(getApplicationContext(), "Fields must not be empty", Toast.LENGTH_LONG).show();
                }
                else {
		    pd = new ProgressDialog(BookTripActivity.this);
                    pd.setMessage("Generating Results! Please wait...");
                    pd.show();
                    Intent toSurvey = new Intent(getApplicationContext(), ResultsActivity.class);
                    String toLoc = toL.getText().toString();
                    toSurvey.putExtra("toLocation", toLoc);
                    startActivity(toSurvey);
                }
            }
        });
    }
}
