package com.ryzen.remedi;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class page_dog_1 extends AppCompatActivity {

    TextView quoteText;
    final String url = "http://api.forismatic.com/api/1.0/?method=getQuote&format=text&lang=en";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_dog_1);

        // Quote Text
        quoteText = (TextView) findViewById(R.id.quoteText);
        final Typeface font = Typeface.createFromAsset(getAssets(), "fonts/antonio_reg.ttf");
        quoteText.setTypeface(font);

        // Executes Forismatic API
        new getAPI().execute(url);

        // Back Button
        final ImageView backBtn = (ImageView) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backBtn.setImageResource(R.drawable.back_btn_black);
                Intent intent = new Intent(page_dog_1.this, pet_page_1.class);
                startActivity(intent);
                finish();
            }
        });

        // Home Button
        final ImageView homeBtn = (ImageView) findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeBtn.setImageResource(R.drawable.home_btn_black);
                Intent intent = new Intent(page_dog_1.this, MainActivity.class);
                startActivity(intent);
                finish();
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
