package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_my_reservation, btn_online_inquiry, btn_appoint, btn_map, btn_health_education, btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_my_reservation = findViewById(R.id.btn_my_reservation);
        btn_online_inquiry = findViewById(R.id.btn_online_inquiry);
        btn_appoint = findViewById(R.id.btn_appoint);
        btn_map = findViewById(R.id.btn_map);
        btn_health_education = findViewById(R.id.btn_health_education);
        btn_logout = findViewById(R.id.btn_logout);
        setListeners();

    }

    private void setListeners() {
        Onclick onlick = new Onclick();
        btn_my_reservation.setOnClickListener(onlick);
        btn_online_inquiry.setOnClickListener(onlick);
        btn_appoint.setOnClickListener(onlick);
        btn_map.setOnClickListener(onlick);
        btn_health_education.setOnClickListener(onlick);
        btn_logout.setOnClickListener(onlick);

    }

    private class Onclick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            int vId=v.getId();
            if(vId==R.id.btn_my_reservation){
                intent = new Intent(MainActivity.this, MyReservationActivity.class);
            } else if (vId==R.id.btn_online_inquiry) {
                intent = new Intent(MainActivity.this, OnlineInquiryActivity.class);
            } else if (vId==R.id.btn_appoint) {
                intent = new Intent(MainActivity.this, AppointmentActivity.class);
            } else if (vId==R.id.btn_map) {
                intent = new Intent(MainActivity.this, MapActivity.class);
            } else if (vId==R.id.btn_health_education) {
                intent = new Intent(MainActivity.this, HealthEducationActivity.class);
            } else if (vId==R.id.btn_logout) {
                intent = new Intent(MainActivity.this, LoginActivity.class);
            }
            startActivity(intent);
        }
    }
}