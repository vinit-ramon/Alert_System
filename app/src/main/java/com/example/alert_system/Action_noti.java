package com.example.alert_system;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Action_noti extends AppCompatActivity {
    String Info;
    TextView logger;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_noti);
        Info = "This Action will send the alert to all later when integrated with Main Project";
        logger = findViewById(R.id.logger);
        logger.setText(Info);

    }
}