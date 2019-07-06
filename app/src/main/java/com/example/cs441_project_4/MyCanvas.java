package com.example.cs441_project_4;

import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;


public class MyCanvas extends SurfaceView implements SurfaceHolder.Callback
{
    public SurfaceHolder surfaceHolder = null;
    private Paint paint = null;
    private float x, y;

    public MyCanvas(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.RED);
    }


    public void draw(){
        surfaceHolder = getHolder();

        Canvas canvas = surfaceHolder.lockCanvas();
        Paint surfaceBackgound = new Paint();
        surfaceBackgound.setColor(Color.BLACK);
        canvas.drawLine(20,20,20,20,paint);
        paint.setColor(Color.RED);
        surfaceHolder.unlockCanvasAndPost(canvas);
    }


    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        paint = null;
    }
}
