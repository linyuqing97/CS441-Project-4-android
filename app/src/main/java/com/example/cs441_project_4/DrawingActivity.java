package com.example.cs441_project_4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;

public class DrawingActivity extends AppCompatActivity {

    MyCanvas myCanvas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_drawing);

//        SeekBar seekBarB = (SeekBar)findViewById(R.id.seekBarB);
//        SeekBar seekBarM = (SeekBar)findViewById(R.id.seekBarM);
//        Button button = (Button)findViewById(R.id.buttton);
//        LinearLayout layout = (LinearLayout)findViewById(R.id.customViewLayout);


        myCanvas = new MyCanvas(this);
        myCanvas.setBackgroundColor(Color.BLACK);
        setContentView(myCanvas);

        ;




    }
}
