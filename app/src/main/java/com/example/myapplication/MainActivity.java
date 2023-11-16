package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_my_reservation,btn_online_inquiry,btn_appoint,btn_map,btn_health_education,btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_my_reservation= (Button) findViewById(R.id.btn_my_reservation);
        btn_online_inquiry= (Button) findViewById(R.id.btn_online_inquiry);
        btn_appoint= (Button) findViewById(R.id.btn_appoint);
        btn_map= (Button) findViewById(R.id.btn_map);
        btn_health_education= (Button) findViewById(R.id.btn_health_education);
        btn_logout=(Button) findViewById(R.id.btn_logout);

        btn_my_reservation.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MyReservationActivity.class);
            startActivity(intent);
        });

        btn_online_inquiry.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, OnlineInquiryActivity.class);
            startActivity(intent);
        });

        btn_appoint.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AppointmentActivity.class);
            startActivity(intent);
        });

        btn_map.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MapActivity.class);
            startActivity(intent);
        });

        btn_health_education.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, HealthEducationActivity.class);
            startActivity(intent);
        });

        btn_logout.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });
    }
}