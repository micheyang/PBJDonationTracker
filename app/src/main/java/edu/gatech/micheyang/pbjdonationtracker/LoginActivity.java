package edu.gatech.micheyang.pbjdonationtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import model.User;

public class LoginActivity extends AppCompatActivity {

    private EditText username; // variable to store username input
    private EditText password; // variable to store password input
    private TextView invalid_login; //the text notification for a bad login attempt

    /***
     * Method that creates the activity when it is launched.
     *
     * @param savedInstanceState the saved instanced state/null (if nothing saved)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //initialize data with inputted information from the user
        username = (EditText) findViewById(R.id.enterLoginUsername);
        password = (EditText) findViewById(R.id.enterLoginPassword);
        invalid_login = (TextView) findViewById(R.id.invalidNotification);

    }

    /**
     * The method called when the user cancels/backs out of a login attempt w/ "Cancel"
     *
     * @param view the selected view
     */
    public void onCancelPressed(View view) {
        Log.d("Edit", "canceled");
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * The method called when the user attempts to log-in to their account w/ "Login"
     * If the user enters an existing username w/ matching password, they are directed
     * into the application (success). Otherwise, user is notified of failed attempt.
     *
     * @param view the selected view
     */
    public void onLoginButtonPressed(View view) {
        Log.d("Edit", "Logged In");

        //login unsuccessful, i.e. inputs do not match existing data
        if (!validate(username.getText().toString(), password.getText().toString())) {
            invalid_login.setVisibility(View.VISIBLE); //show bad attempt notification

        } else { //login successful, i.e. inputs match existing data
            Intent intent = new Intent(LoginActivity.this, AppScreen.class);
            startActivity(intent); //go into application
        }
    }

    /**
     * This function checks the inputted username and password by the user on
     * the login screen. For M5, this requires checking if the user's username
     * matches his/her stated password in the user database system.
     *
     * @param user the inputted username by the user
     * @param pass the inputted password by the user
     * @return true if matches the hardcoded 'test' user/pass, false otherwise
     */
    public boolean validate(String user, String pass) {

        /**
        //retrieve username and password user entered from RegistrationActivity.java
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String usernameStr = extras.getString("user_username");
            String passwordStr = extras.getString("user_password");
            //validate if username and password match
            return (user.equals(usernameStr) && pass.equals(passwordStr));
        }
        return (false);
         **/

        /**
         //if user's inputted username exists in user database
         if (RegistrationActivity.usersSystem.containsUser(user)) {
         User userInSystem = RegistrationActivity.usersSystem.getUser(user);
         //if user's inputted password matches the username associated with it
         if (RegistrationActivity.usersSystem.matchPassword(pass, userInSystem)) {
         return (true);
         }
         }
         return (false);
         **/

        return user.equals("user") && (pass.equals("pass"));
    }


}
