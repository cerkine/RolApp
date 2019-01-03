package com.example.cerkine.dam07_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Circle;


public class LogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        GlideApp.with(this).load(R.drawable.fondoinicio).into((ImageView)findViewById(R.id.fondoLogo));

        ProgressBar progressBar = (ProgressBar)findViewById(R.id.spin_kit);
        Sprite doubleBounce = new Circle();
        progressBar.setIndeterminateDrawable(doubleBounce);

        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(5000);  //Delay of 5 seconds
                } catch (Exception e) {

                } finally {

                    Intent i = new Intent(LogoActivity.this,
                            LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        welcomeThread.start();
//        findViewById(R.id.logoActivity).setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view)
//            {
//                Intent intent = new Intent(LogoActivity.this, LoginActivity.class);
//                startActivity(intent);
//            }
//        });
    }



}
