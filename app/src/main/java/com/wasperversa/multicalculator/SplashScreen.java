package com.wasperversa.multicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progress = 0;
    private Handler handler = new Handler(Looper.getMainLooper());


    // After completion of 5000 ms, the next activity will get started.
    private static final int SPLASH_SCREEN_TIME_OUT = 1500;
    private static final int PROGRESS_UPDATE_INTERVAL = 5; // Update progress every 50ms

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //This method is used so that your splash activity
        //can cover the entire screen.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_splash_screen);

        progressBar = findViewById(R.id.pb);

        // Start updating progress bar
        handler.post(updateProgress);

        // Start a delayed Runnable to launch the main activity
        new Handler().postDelayed(() -> {
            Intent i = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(i);
            finish();
        }, SPLASH_SCREEN_TIME_OUT);
    }

    // Runnable to update progress bar
    private Runnable updateProgress = new Runnable() {
        @Override
        public void run() {
            progress += 1;
            progressBar.setProgress(progress);

            if (progress < 100) {
                handler.postDelayed(this, PROGRESS_UPDATE_INTERVAL);
            } else {
                handler.removeCallbacks(this); // Stop updating if progress reaches 100
            }
        }
    };


}