package com.example.alert_system;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;


public class Simplenoti extends  AppCompatActivity {
    String info;
    TextView logger;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_noti);
        info = "This is a simple Notification";
        logger = findViewById(R.id.logger);
        logger.setText(info);

    }
}
