package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class AppointmentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoint);

        // set the selection of time spinner
        Spinner timeSpinner = findViewById(R.id.timeSpinner);
        ArrayAdapter<CharSequence> time_adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_time_am, android.R.layout.simple_spinner_item);
        timeSpinner.setAdapter(time_adapter);

        // set the selection of different departments
        ListView departmentListView = findViewById(R.id.departmentList);
        String[] departments = getResources().getStringArray(R.array.department_name);
        ArrayAdapter<String> department_adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, departments);
        departmentListView.setAdapter(department_adapter);

        // match different doctors when choosing different departments
        Spinner doctorSpinner = findViewById(R.id.doctorSpinner);

    }

}