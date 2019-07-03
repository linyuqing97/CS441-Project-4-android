package com.example.cs441_project_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tableButton = (Button)findViewById(R.id.tableButton);
        Button drawingButton = (Button)findViewById(R.id.drawingButton);
        Button webButton = (Button)findViewById(R.id.talkToWebButton);


        tableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent starIntent = new Intent(getApplicationContext(), TableActivity.class);
                startActivity(starIntent);
            }
        });

        drawingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent starIntent = new Intent(getApplicationContext(), DrawingActivity.class);
                startActivity(starIntent);
            }
        });

        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent starIntent = new Intent(getApplicationContext(), WebActivity.class);
                startActivity(starIntent);
            }
        });
    }
}
