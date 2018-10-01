package edu.gatech.micheyang.pbjdonationtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {

    private EditText username; //username input
    private EditText password; //password input
    private TextView invalid_login; //text notification for bad login attempt
    private Button loginButton; //login button
    private Button cancelButton; //cancel button


    /***
     * Method that creates the activity when it is launched.
     *
     * @param savedInstanceState the saved instanced state/null (if nothing saved)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        login();
        cancel();
    }

    public void login() {
        Log.d("Edit", "attempt login");
        username = (EditText) findViewById(R.id.enterLoginUsername);
        password = (EditText) findViewById(R.id.enterLoginPassword);
        invalid_login = (TextView) findViewById(R.id.invalidNotification);

        loginButton = (Button) findViewById(R.id.buttonLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                currentUserDatabase();
                if (!validate(username.getText().toString(), password.getText().toString())) {
                    invalid_login.setVisibility(View.VISIBLE);
                } else {
                    Intent intent = new Intent("edu.gatech.micheyang.pbjdonationtracker.AppScreen");
                    startActivity(intent);
                }
            }
        });
    }

    public void cancel() {
        Log.d("Edit", "cancel login");
        cancelButton = findViewById(R.id.buttonCancelLogin);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.MainActivity");
                startActivity(intent);
            }
        });
    }

    private boolean validate(String _username, String _password) {
        if (UserDatabase.usernames.size() == 0) { return false; }
        else if (_username == null || _password == null) { return false; }
        for (int i = 0; i < UserDatabase.usernames.size(); i++) {
            if (UserDatabase.usernames.get(i).equals(_username)) {
                return UserDatabase.passwords.get(i).equals(_password);
            }
        }
        return false;
    }

    private void currentUserDatabase() {
        for (int i = 0; i < UserDatabase.usernames.size(); i++) {
            Log.d("USER", "Username: " + UserDatabase.usernames.get(i));
            Log.d("PASS", "Password: " + UserDatabase.passwords.get(i));
            Log.d("MAIL", "Email: " + UserDatabase.emails.get(i));
        }
    }
//    /**
//     * The method called when the user cancels/backs out of a login attempt w/ "Cancel"
//     *
//     * @param view the selected view
//     */
//    public void onCancelPressed(View view) {
//        Log.d("Edit", "canceled");
//        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//        startActivity(intent);
//    }
//
//    /**
//     * The method called when the user attempts to log-in to their account w/ "Login"
//     * If the user enters an existing username w/ matching password, they are directed
//     * into the application (success). Otherwise, user is notified of failed attempt.
//     *
//     * @param view the selected view
//     */
//    public void onLoginButtonPressed(View view) {
//        Log.d("Edit", "Logged In");
//
//        //initialize data with inputted information from the user
//        EditText username = findViewById(R.id.enterLoginUsername);
//        EditText password = findViewById(R.id.enterLoginPassword);
//        TextView invalid_login = findViewById(R.id.invalidNotification);
//
//        //login unsuccessful, i.e. inputs do not match existing data
//        if (!validate(username.getText().toString(), password.getText().toString())) {
//            invalid_login.setVisibility(View.VISIBLE); //show bad attempt notification
//        } else { //login successful, i.e. inputs match existing data
//            Intent intent = new Intent(LoginActivity.this, AppScreen.class);
//            startActivity(intent); //go into application
//        }
//    }
//
//    /**
//     * Method to check user's login inputs. Valid if an existing username with matching
//     * password associated is entered by the user. Invalid otherwise.
//     *
//     * @param user the inputted username by the user
//     * @param pass the inputted password by the user
//     * @return true if user enters valid information, false if any invalid inputs.
//     */
//    public boolean validate(String user, String pass) {
//        return user.equals("user") && pass.equals("pass");
//    }
}
