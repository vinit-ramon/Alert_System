package com.example.alert_system;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Bignoti extends AppCompatActivity {
    String Info;
    TextView logger;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.big_noti);
        Info = "This is the big notification . This can be seen on fullscreen only" +
                "It contains sensitie info";
        logger = findViewById(R.id.logger);
        logger.setText(Info);


    }
}
