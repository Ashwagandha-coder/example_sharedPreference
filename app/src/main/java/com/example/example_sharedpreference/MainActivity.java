package com.example.example_sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private TextView textView;

    private SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = (sharedPreferences, s) -> {

        if (s.equals("flat")) {

            sharedPreferences.edit()
                    .putInt("flat",89)
                    .apply();
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextView();
        initApp();
        unsubscriber();
    }

    public void initApp() {

        sharedPreferences = getSharedPreferences("DB",MODE_PRIVATE);

        sharedPreferences.edit()
                .putInt("flat",1)
                .apply();


        textView.setText(sharedPreferences.getInt("flat",5));




        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);

    }

    public void initTextView() {

        textView = findViewById(R.id.tv_main);


    }

    public void unsubscriber() { sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener); }

}