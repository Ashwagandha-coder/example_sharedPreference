package com.example.example_sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextView();
        initApp();
    }

    public void initApp() {

        sharedPreferences = getSharedPreferences("DB",MODE_PRIVATE);

        sharedPreferences.edit()
                .putInt("flat",1)
                .apply();


        textView.setText(sharedPreferences.getInt("flat",5));

    }

    public void initTextView() {

        textView = findViewById(R.id.tv_main);


    }

}