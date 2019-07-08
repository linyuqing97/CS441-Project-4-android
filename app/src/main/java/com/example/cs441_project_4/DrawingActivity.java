package com.example.cs441_project_4;

import androidx.appcompat.app.AppCompatActivity;


import android.os.AsyncTask;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

interface NetResponse{
    void netResult(Integer code, JSONArray json);
}


public class DrawingActivity extends AppCompatActivity implements NetResponse {


    MyCanvas myCanvas;
    float m=0,b = 0;
    NetTask netTask;
    TextView computeResult;
    String updateString;
    DrawingActivity handle;
    Button getWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing);

        SeekBar seekBarB = (SeekBar)findViewById(R.id.seekBarB);

        Button button = (Button)findViewById(R.id.buttton);
        getWeb = (Button)findViewById(R.id.getWeb);
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
        handle = this;
        getWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Clicked the compute button");


                System.out.println(m);
                String request = "value=" + m;
                netTask = new NetTask("https://cs.binghamton.edu/~pmadden/php/double.php", request, handle);

                netTask.execute((Void) null);
            }
        });

    }
    public void netResult(Integer code, JSONArray json)
    {
        System.out.println("Got a result from the web");
        updateString = "";

        for (int i = 0; i < json.length(); ++i)
        {
            System.out.println("Looping");
            try {
                JSONObject item = json.getJSONObject(i);

                if (item.getString("result") != null) {
                    System.out.println("Found a match");
                    System.out.println(item.getString("result"));
                    updateString = item.getString("result");


                }
            }
            catch (JSONException e)
            {
                updateString = "JSON Error!";
            }

            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    m = Integer.parseInt(updateString);
                    System.out.println("M is now : "+m);

                    myCanvas.setStopY(m*(myCanvas.getStopX())+b);

                    myCanvas.draw();

                }
            });
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


    public class NetTask extends AsyncTask<Void, Void, Boolean> {
        private final String urlString;
        private final String reqString;
        private NetResponse changeListener;

        NetTask(String url, String request, NetResponse responseListener) {
            urlString = url; reqString = request; changeListener = responseListener;
        }
        @Override
        protected Boolean doInBackground(Void... params) {
            try {
                System.out.println("JSON Query: " + reqString);
                // JSONObject json = readJsonFromUrl("https://graph.facebook.com/19292868552");
                // JSONObject json = readJsonFromUrl("https://cnn.com");
                // System.out.println(reqString);
                JSONArray json = readJsonFromUrl(reqString);
                System.out.println("Finished getting json.");
                if (json != null)
                    System.out.println(json.toString());

                if (changeListener != null)
                    changeListener.netResult(0, json);

                //System.out.println("Notify that JSON has come in");
                // if (noteConnector != null)
                //    noteConnector.ncnotify(0, "");

            } catch (IOException e) {
                System.out.println("IO exception");
                //System.out.println(e);
                if (changeListener != null)
                    changeListener.netResult(1, null);
            } catch (JSONException e) {
                System.out.println("JSON Didn't work");
                //System.out.println(e);
                if (changeListener != null)
                    changeListener.netResult(2, null);
            }
            return true;
        }

        private String readAll(Reader rd) throws IOException {
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            System.out.println("Read from the URL");
            System.out.println(sb.toString());
            System.out.println("Going to try to turn it into json");
            return sb.toString();
        }

        public JSONArray readJsonFromUrl(String request) throws IOException, JSONException {
            URL nurl = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) nurl.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            System.out.println("Network request to " + urlString + " with request " + reqString);
            OutputStream urlout = connection.getOutputStream();
            System.out.println("here");

            //String s = "id=3452&second=fjfjfjfj";
            urlout.write(request.getBytes());
            urlout.close();
            InputStream is = connection.getInputStream();

            System.out.println("Waiting for network stream");
            try {
                BufferedReader rd = new BufferedReader(new InputStreamReader(is));
                String jsonText = readAll(rd);
                System.out.println("JSON is " + jsonText);

                JSONArray jarray = new JSONArray(jsonText);


                System.out.println("Got the object");
                return jarray;
            } finally {
                is.close();
                // System.out.println("Did not get the object.");
            }


        }
    }

}








