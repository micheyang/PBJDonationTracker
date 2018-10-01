package edu.gatech.micheyang.pbjdonationtracker;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        //handler to send/process messages & runnable objects in thread
        final Handler dataHandler = new Handler();
        dataHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent startMain = new Intent(HomeScreen.this, MainActivity.class);
                HomeScreen.this.startActivity(startMain);
                HomeScreen.this.finish();
            }
        }, 2000);
    }
}
