package com.ryzen.remedi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Vibrator;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.View.OnTouchListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class page_human_1 extends AppCompatActivity{

    ImageView info_bg;
    ImageView homeBtn;
    ImageView backBtn;
    Vibrator vibrator;
    MediaPlayer popSound;
    ScrollView sw;
    TextView quoteText;
    final String url = "http://api.forismatic.com/api/1.0/?method=getQuote&format=text&lang=en";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_human_1);

        info_bg = (ImageView) findViewById(R.id.info_show);
        popSound=MediaPlayer.create(page_human_1.this, R.raw.pop_sound);
        homeBtn = (ImageView) findViewById(R.id.homeBtn);
        backBtn = (ImageView) findViewById(R.id.backBtn);

        // Quote Text
        quoteText = (TextView) findViewById(R.id.quoteText);
        final Typeface font = Typeface.createFromAsset(getAssets(), "fonts/antonio_reg.ttf");
        quoteText.setTypeface(font);

        // Executes Forismatic API
        new getAPI().execute(url);

        sw = (ScrollView) findViewById(R.id.page_human_scroll);

        // Buttons changes color on click and hold
        final ImageView coughBtn = (ImageView) findViewById(R.id.cough_btn);
        coughBtn.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        showInfo();
                        coughBtn.setImageResource(R.drawable.human_symptom_blue_cough);
                        info_bg.setImageResource(R.drawable.human_symptom_info_cough);
                        break;
                    case MotionEvent.ACTION_UP:
                        hideInfo();
                        coughBtn.setImageResource(R.drawable.human_symptom_cough);
                        break;
                }
                return true;
            }
        });
        final ImageView congestBtn = (ImageView) findViewById(R.id.congest_btn);
        congestBtn.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        showInfo();
                        congestBtn.setImageResource(R.drawable.human_symptom_blue_congestion);
                        info_bg.setImageResource(R.drawable.human_symptom_info_congest);
                        break;
                    case MotionEvent.ACTION_UP:
                        hideInfo();
                        congestBtn.setImageResource(R.drawable.human_symptom_congestion);
                        break;
                }
                return true;
            }
        });
        final ImageView backstrainBtn = (ImageView) findViewById(R.id.back_btn);
        backstrainBtn.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        showInfo();
                        backstrainBtn.setImageResource(R.drawable.human_symptom_blue_backstrain);
                        info_bg.setImageResource(R.drawable.human_symptom_info_back);
                        break;
                    case MotionEvent.ACTION_UP:
                        hideInfo();
                        backstrainBtn.setImageResource(R.drawable.human_symptom_backstrain);
                        break;
                }
                return true;
            }
        });
        final ImageView throatBtn = (ImageView) findViewById(R.id.throat_btn);
        throatBtn.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        showInfo();
                        throatBtn.setImageResource(R.drawable.human_symptom_blue_sore);
                        info_bg.setImageResource(R.drawable.human_symptom_info_sore);
                        break;
                    case MotionEvent.ACTION_UP:
                        hideInfo();
                        throatBtn.setImageResource(R.drawable.human_symptom_sorethroat);
                        break;
                }
                return true;
            }
        });
        final ImageView crampBtn = (ImageView) findViewById(R.id.cramp_btn);
        crampBtn.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        showInfo();
                        crampBtn.setImageResource(R.drawable.human_symptom_blue_cramping);
                        info_bg.setImageResource(R.drawable.human_symptom_info_cramp);
                        break;
                    case MotionEvent.ACTION_UP:
                        hideInfo();
                        crampBtn.setImageResource(R.drawable.human_symptom_cramping);
                        break;
                }
                return true;
            }
        });
        final ImageView dizzyBtn = (ImageView) findViewById(R.id.dizzy_btn);
        dizzyBtn.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        showInfo();
                        dizzyBtn.setImageResource(R.drawable.human_symptom_blue_dizzy);
                        info_bg.setImageResource(R.drawable.human_symptom_info_dizzy);
                        break;
                    case MotionEvent.ACTION_UP:
                        hideInfo();
                        dizzyBtn.setImageResource(R.drawable.human_symptom_dizziness);
                        break;
                }
                return true;
            }
        });
        final ImageView runnyBtn = (ImageView) findViewById(R.id.runny_btn);
        runnyBtn.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        showInfo();
                        runnyBtn.setImageResource(R.drawable.human_symptom_blue_runny);
                        info_bg.setImageResource(R.drawable.human_symptom_info_runny);
                        break;
                    case MotionEvent.ACTION_UP:
                        hideInfo();
                        runnyBtn.setImageResource(R.drawable.human_symptom_runnynose);
                        break;
                }
                return true;
            }
        });
        final ImageView feverBtn = (ImageView) findViewById(R.id.fever_btn);
        feverBtn.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        showInfo();
                        feverBtn.setImageResource(R.drawable.human_symptom_blue_fever);
                        info_bg.setImageResource(R.drawable.human_symptom_info_fever);
                        break;
                    case MotionEvent.ACTION_UP:
                        hideInfo();
                        feverBtn.setImageResource(R.drawable.human_symptom_fever);
                        break;
                }
                return true;
            }
        });
        final ImageView rashBtn = (ImageView) findViewById(R.id.rash_btn);
        rashBtn.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        showInfo();
                        rashBtn.setImageResource(R.drawable.human_symptom_blue_rash);
                        info_bg.setImageResource(R.drawable.human_symptom_info_rash);
                        break;
                    case MotionEvent.ACTION_UP:
                        hideInfo();
                        rashBtn.setImageResource(R.drawable.human_symptom_rash);
                        break;
                }
                return true;
            }
        });
        final ImageView fatigueBtn = (ImageView) findViewById(R.id.fatigue_btn);
        fatigueBtn.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        showInfo();
                        fatigueBtn.setImageResource(R.drawable.human_symptom_blue_fatigue);
                        info_bg.setImageResource(R.drawable.human_symptom_info_fatigue);
                        break;
                    case MotionEvent.ACTION_UP:
                        hideInfo();
                        fatigueBtn.setImageResource(R.drawable.human_symptom_fatigue);
                        break;
                }
                return true;
            }
        });
        final ImageView itchyBtn = (ImageView) findViewById(R.id.itchy_btn);
        itchyBtn.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        showInfo();
                        itchyBtn.setImageResource(R.drawable.human_symptom_blue_itchy);
                        info_bg.setImageResource(R.drawable.human_symptom_info_itchy);
                        break;
                    case MotionEvent.ACTION_UP:
                        hideInfo();
                        itchyBtn.setImageResource(R.drawable.human_symptom_itchyeye);
                        break;
                }
                return true;
            }
        });
        final ImageView nauseaBtn = (ImageView) findViewById(R.id.nausea_btn);
        nauseaBtn.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        showInfo();
                        nauseaBtn.setImageResource(R.drawable.human_symptom_blue_nausea);
                        info_bg.setImageResource(R.drawable.human_symptom_info_nausea);
                        break;
                    case MotionEvent.ACTION_UP:
                        hideInfo();
                        nauseaBtn.setImageResource(R.drawable.human_symptom_nausea);
                        break;
                }
                return true;
            }
        });

        final ImageView backBtn = (ImageView) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backBtn.setImageResource(R.drawable.back_btn_black);
                Intent intent = new Intent(page_human_1.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        final ImageView homeBtn = (ImageView) findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeBtn.setImageResource(R.drawable.home_btn_black);
                Intent intent = new Intent(page_human_1.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
    // Method to show remedies for symptoms
    public void showInfo(){
        popSound.start();
        sw.fullScroll(View.FOCUS_DOWN);
        info_bg.setVisibility(View.VISIBLE);
        homeBtn.setVisibility(View.INVISIBLE);
        backBtn.setVisibility(View.INVISIBLE);
        sw.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }
    // Method to hide remedies
    public void hideInfo(){
        info_bg.setVisibility(View.INVISIBLE);
        homeBtn.setVisibility(View.VISIBLE);
        backBtn.setVisibility(View.VISIBLE);
        sw.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
    }

    private final String USER_AGENT = "Mozilla/5.0";
    // Class to connect to API
    class getAPI extends AsyncTask<String, Void, String> {

        private Exception exception;

        @Override
        protected String doInBackground(String... url) {

            try{
                URL obj = new URL(url[0]);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();

                //add request header
                con.setRequestMethod("POST");
                con.setRequestProperty("User-Agent", USER_AGENT);
                con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

                // Send post request
                con.setDoOutput(true);

                int responseCode = con.getResponseCode();
                System.out.println("\nSending 'POST' request to URL : " + url);
                System.out.println("Response Code : " + responseCode);

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                //print result
                return response.toString();

            }
            catch(Exception e){
                this.exception = e;
                return null;
            }
        }
        protected void onPostExecute(String response){

            if (exception != null)
                quoteText.setText(exception.toString());
            else
                quoteText.setText(response.toString());
        }
    }
}


