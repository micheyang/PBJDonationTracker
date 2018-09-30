package edu.gatech.micheyang.pbjdonationtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import model.User;
import model.UserDatabase;

public class RegistrationActivity extends AppCompatActivity {

    public static UserDatabase usersSystem;
    private EditText username; // variable to store username input
    private EditText password; // variable to store password input
    private EditText email; //variable to store email input
    private TextView invalid_username; //text notification for a bad username

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //initialize data with inputted information from the user
        username = (EditText) findViewById(R.id.regNameEntry);
        password = (EditText) findViewById(R.id.regPassEntry);
        email = (EditText) findViewById(R.id.regEmailEntry);
        invalid_username = (TextView) findViewById(R.id.badUsernameNotification);
    }

    /**
     * The method called when the user attempts to register
     * by pressing "Register"
     *
     * @param view the selected view
     */
    public void onRegButtonPressed(View view) {
        Log.d("Edit", "Registered");
        // Check if new user should be accepted/added to system here
          //if username is unique and password is non-null, add to system
        String usernameStr = username.getText().toString();
        String passwordStr = password.getText().toString();
        String emailStr = email.getText().toString();

        /**if (!(usersSystem.containsUser(usernameStr))) {
            //make a new user
            //User newUser = new User(usernameStr, passwordStr, emailStr);
            //add them to the usersSystem
            //usersSystem.addUser(newUser);**/
            Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
            startActivity(intent); //go login

        /**} else {
            //invalid_username.setVisibility(View.VISIBLE); //show bad attempt notification
        }**/
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
