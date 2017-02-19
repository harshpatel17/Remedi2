package com.ryzen.remedi;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.util.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    private TextView quoteText;
    final String url = "http://api.forismatic.com/api/1.0/?method=getQuote&format=text&lang=en";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Calls Forismatic API
        new getAPI().execute(url);

        // References song from raw folder
        MediaPlayer opmSong = MediaPlayer.create(MainActivity.this, R.raw.opm);
        opmSong.start();

        // Text details of quotes
        quoteText = (TextView) findViewById(R.id.quoteText);
        final Typeface font = Typeface.createFromAsset(getAssets(), "fonts/antonio_reg.ttf");
        quoteText.setTypeface(font);

        // Whole Screen becomes a button to next page
        ImageButton nextPage = (ImageButton) findViewById(R.id.next_page_btn);
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, page_2.class);
                startActivity(intent);
            }
        });
    }

    private final String USER_AGENT = "Mozilla/5.0";

    class getAPI extends AsyncTask<String, Void, String> {

        private Exception exception;

        @Override
        protected String doInBackground(String... url) {

            try {
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

            } catch (Exception e) {
                this.exception = e;
                return null;
            }
        }

        protected void onPostExecute(String response) {

            if (exception != null)
                quoteText.setText(exception.toString());
            else
                quoteText.setText(response.toString());
        }
    }
}