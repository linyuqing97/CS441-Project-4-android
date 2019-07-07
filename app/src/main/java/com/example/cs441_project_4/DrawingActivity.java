package com.example.cs441_project_4;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import android.widget.LinearLayout;
import android.widget.SeekBar;


public class DrawingActivity extends AppCompatActivity {


    MyCanvas myCanvas;
    float m=0,b = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);

        SeekBar seekBarB = (SeekBar)findViewById(R.id.seekBarB);

        Button button = (Button)findViewById(R.id.buttton);

        LinearLayout layout = (LinearLayout)findViewById(R.id.customViewLayout);
        myCanvas = new MyCanvas(getApplicationContext());
        layout.addView(myCanvas);

        SeekBar seekBarM = (SeekBar)findViewById(R.id.seekBarM);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                    myCanvas.firstDraw();
            }
        });



        seekBarM.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int mChange,boolean fromUser) {
                // TODO Auto-generated method stub
                    m=mChange;

                    myCanvas.setStopY(m*(myCanvas.getStopX())+b);

                   // myCanvas.setStarY(myCanvas.getStarX()+b);
                    System.out.println("m:"+m+ " b"+b+ "StarY: "+myCanvas.getStarY()+" StopY"+myCanvas.getStopY());
                    myCanvas.draw();
            }



        });
        seekBarB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int bChang,boolean fromUser) {
                // TODO Auto-generated method stub
                b=bChang;
                myCanvas.setStopY(m*myCanvas.getStopX()+b);
                myCanvas.setStarY(m*(myCanvas.getStarX())+b);

                myCanvas.draw();
            }



        });

    }
}
