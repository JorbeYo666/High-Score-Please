package com.example.myapplication.tool;

import android.content.Context;

import com.example.myapplication.R;
import com.example.myapplication.entity.Disease;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JsonTools {
    public static List<Disease> loadDiseasesFromJson(Context context) {
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.disease);
            Reader reader = new BufferedReader(new InputStreamReader(inputStream));
            Gson gson = new Gson();
            Type type = new TypeToken<List<Disease>>() {}.getType();
            return gson.fromJson(reader, type);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    public static Set<String> loadSymptomsFromJson(Context context) {
        List<Disease> diseases = loadDiseasesFromJson(context);
        Set<String> knownSymptoms = new HashSet<>();
        for (Disease disease : diseases) {
            knownSymptoms.addAll(disease.getSymptoms());
        }
        return knownSymptoms;
    }


}
