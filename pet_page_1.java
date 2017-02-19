package com.ryzen.remedi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class pet_page_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_page_1);

        ImageView dogBtn = (ImageView) findViewById(R.id.dogBtn);
        dogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pet_page_1.this, page_dog_1.class);
                startActivity(intent);
            }
        });
        ImageView catBtn = (ImageView) findViewById(R.id.catBtn);
        catBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (pet_page_1.this, page_cat_1.class);
                startActivity(intent);
            }
        });
        ImageView rabbitBtn = (ImageView) findViewById(R.id.rabbitBtn);
        rabbitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pet_page_1.this, page_rabbit_1.class);
                startActivity(intent);
            }
        });

        final ImageView backBtn = (ImageView) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backBtn.setImageResource(R.drawable.back_btn_black);
                Intent intent = new Intent(pet_page_1.this, page_2.class);
                startActivity(intent);
                finish();
            }
        });
        final ImageView homeBtn = (ImageView) findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeBtn.setImageResource(R.drawable.home_btn_black);
                Intent intent = new Intent(pet_page_1.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
