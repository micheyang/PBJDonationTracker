package edu.gatech.micheyang.pbjdonationtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void onRegButtonPressed(View view) {
        Log.d("Edit", "Registered");
        // Check if new user should be accepted/added to system here

        Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
        startActivity(intent); //go login

    }
    /**
     * The method called when the user cancels/backs out of registering w/ "Cancel"
     *
     * @param view the selected view
     */
    public void onCancelPressed(View view) {
        Log.d("Edit", "canceled");
        Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
        startActivity(intent);
    }

}
