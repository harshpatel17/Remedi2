package com.ryzen.remedi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class page_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_2);

        // Human Button to human section
        ImageView humanBtn = (ImageView) findViewById(R.id.humanBtn);
        humanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(page_2.this, page_human_1.class);
                startActivity(intent);
            }
        });

        // Pet Button to pet section
        ImageView petBtn = (ImageView) findViewById(R.id.petBtn);
        petBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(page_2.this, pet_page_1.class);
                startActivity(intent);
            }
        });

        // Remedy Button to remedies (INCOMPLETE)
        final ImageView remedyBtn = (ImageView) findViewById(R.id.remediesBtn);
        remedyBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        remedyBtn.setImageResource(R.drawable.page_2_remedies_black);
                        break;
                    case MotionEvent.ACTION_UP:
                        remedyBtn.setImageResource(R.drawable.page_2_remedies);
                        break;
                }
                return true;
            }
        });
        remedyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(page_2.this, page_remedies_1.class);
                startActivity(intent);
            }
        });
        // Back Button
        final ImageView backBtn = (ImageView) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backBtn.setImageResource(R.drawable.back_btn_black);
                Intent intent = new Intent(page_2.this, MainActivity.class);
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
                Intent intent = new Intent(page_2.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
