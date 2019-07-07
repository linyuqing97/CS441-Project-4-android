package com.example.cs441_project_4;

import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.jar.Attributes;


public class MyCanvas extends SurfaceView implements SurfaceHolder.Callback
{
    public SurfaceHolder surfaceHolder;
    private Paint paint;
    public float starX =500,starY=500,stopX=900,stopY=900;

    public MyCanvas(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.RED);
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
    public void firstDraw(){

        surfaceHolder = getHolder();
        Canvas canvas = surfaceHolder.lockCanvas();

        Paint surfaceBackground = new Paint();

        surfaceBackground.setColor(Color.BLACK);

        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);

        // Draw the circle.
        paint.setColor(Color.RED);
        paint.setStrokeWidth(50);
        canvas.drawLine(0,0,100,100,paint);
        // canvas.drawLine(starX,starY,stopX,stopY,paint);
        // Unlock the canvas object and post the new draw.
        surfaceHolder.unlockCanvasAndPost(canvas);
    }


    public void draw(){

        surfaceHolder = getHolder();

        // Get and lock canvas object from surfaceHolder.
        Canvas canvas = surfaceHolder.lockCanvas();

        Paint surfaceBackground = new Paint();

        surfaceBackground.setColor(Color.BLACK);

        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);

        // Draw the circle.
        paint.setColor(Color.RED);
        paint.setStrokeWidth(50);
            //canvas.drawLine(500,500,2000,2000,paint);
        canvas.drawLine(starX,starY,stopX,stopY,paint);
        // Unlock the canvas object and post the new draw.
        surfaceHolder.unlockCanvasAndPost(canvas);


    }
    public float getStarX(){return this.starX;};
    public float getStarY(){return this.starY;};
    public float getStopX(){return this.stopX;};
    public float getStopY(){return this.stopY;};


    public void setStarX(float x) { this.starX = x; }
    public void setStarY(float y) {
        this.starY = y;
    }
    public void setStopX(float stopX) {
        this.stopX = stopX;
    }
    public void setStopY(float stopY) {
        this.stopY = stopY;
    }
}
