package edu.gatech.micheyang.pbjdonationtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    /***
     * Method that creates the activity when it is launched.
     *
     * @param savedInstanceState the saved instanced state/null (if nothing saved)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /***
     * The method called when a user requests to log-in to application w/ "LOGIN"
     *
     * @param view the selected view
     */
    public void onLoginPressed(View view) {
        Log.d("Edit", "Log in");
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    /***
     * The method called when a user requests to make a new account w/ "REGISTER"
     *
     * @param view the selected view
     */
    public void onRegisterPressed(View view) {
        Log.d("Edit", "Log in");
        Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
        startActivity(intent);
    }
}
