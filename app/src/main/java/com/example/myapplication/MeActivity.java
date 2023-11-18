package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.myapplication.R;

import java.util.Objects;

public class MeActivity extends AppCompatActivity {
    private ImageButton btn_home,btn_myReservation;
    private CardView reservationCard;
    private TextView btn_myReservation_text;
    private ImageView btn_me_refresh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();

        setContentView(R.layout.activity_me);

        btn_home=(ImageButton) findViewById(R.id.btn_home);
        btn_myReservation=(ImageButton) findViewById(R.id.btn_myReservation);
        reservationCard=(CardView) findViewById(R.id.reservationCard);
        btn_myReservation_text=(TextView) findViewById(R.id.btn_myReservation_text);
        btn_me_refresh=(ImageView) findViewById(R.id.btn_me_refresh);


        btn_home.setOnClickListener(view -> {

            Intent intent = new Intent(MeActivity.this, MainActivity.class);
            startActivity(intent);

        });
        btn_myReservation.setOnClickListener(view -> {
            Intent intent = new Intent(MeActivity.this, MyReservationActivity.class);
            startActivity(intent);
        });
        reservationCard.setOnClickListener(view -> {
            Intent intent = new Intent(MeActivity.this, MyReservationActivity.class);
            startActivity(intent);
        });
        btn_myReservation_text.setOnClickListener(view -> {
            Intent intent = new Intent(MeActivity.this, MyReservationActivity.class);
            startActivity(intent);
        });
        btn_me_refresh.setOnClickListener(v -> {
            Intent intent = new Intent(MeActivity.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(MeActivity.this, "Refresh successfully", Toast.LENGTH_SHORT).show();

        });
    }
}