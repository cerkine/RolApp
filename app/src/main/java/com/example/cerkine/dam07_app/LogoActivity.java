package com.example.cerkine.dam07_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        findViewById(R.id.logoActivity).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {
                Intent intent = new Intent(LogoActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void nextActivity(){
        try {
            Thread.sleep(10000);

            Intent intent = new Intent(LogoActivity.this, LoginActivity.class);
            startActivity(intent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
