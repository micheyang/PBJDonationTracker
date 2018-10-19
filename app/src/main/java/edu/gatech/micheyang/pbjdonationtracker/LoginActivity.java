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
    private int equalsTracker;

    /***
     * Method that creates the activity when it is launched.
     *
     * @param savedInstanceState the saved instanced state/null (if nothing saved)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login(); //handles actions for user wanting to login
        cancel(); //handles actions for user cancelling login
    }

    /**
     * Checks the user's login/password inputs (w/ database lists) if a login attempt is made.
     * If the user enters existing username & matching password, the user is directed into app.
     * Otherwise, the user is notified of invalid/failed login attempt on login screen.
     */
    public void login() {
        Log.d("Edit", "attempt login");
        username = (EditText) findViewById(R.id.enterLoginUsername);
        password = (EditText) findViewById(R.id.enterLoginPassword);
        invalid_login = (TextView) findViewById(R.id.invalidNotification);

        //a login button click will check user's inputs for validity
        loginButton = (Button) findViewById(R.id.buttonLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                currentUserDatabase();
                if (!validate(username.getText().toString(), password.getText().toString())) {
                    invalid_login.setVisibility(View.VISIBLE); //notify user of bad attempt
                } else { //successful attempt will direct user to application
                    if (userTypeValidate()) { //if user is a location employee
                        Intent intent = new Intent("edu.gatech.micheyang.pbjdonationtracker.EmployeeAppScreen");
                        startActivity(intent);
                    } else {
                        Intent intent = new Intent("edu.gatech.micheyang.pbjdonationtracker.AppScreen");
                        startActivity(intent);
                    }
                }
            }
        });
    }

    /**
     * Cancels login attempt and directs user back to MainActivity screen. No user info stored.
     */
    public void cancel() {
        Log.d("Edit", "cancel login");
        //a cancel button click takes user to main screen disregarding any user inputs
        cancelButton = findViewById(R.id.buttonCancelLogin);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.MainActivity");
                startActivity(intent);
            }
        });
    }

    /**
     * Method that determines if user login attempt is successful.
     * If empty database, null inputs, or invalid info then attempt is unsuccessful.
     * @param _username the user's inputted username
     * @param _password the user's inputted password
     * @return true if valid login information, false for null/invalid info
     */
    private boolean validate(String _username, String _password) {
        if (UserDatabase.usernames.size() == 0) { return false; }
        else if (_username == null || _password == null) { return false; }
        for (int i = 0; i < UserDatabase.usernames.size(); i++) {
            if (UserDatabase.usernames.get(i).equals(_username)) {
                equalsTracker = i;
                return UserDatabase.passwords.get(i).equals(_password);
            }
        }
        return false;
    }

    /**
     * Method that determines if user type is a location employee
     * @return true if is a location employee, false if not
     */
    private boolean userTypeValidate() {
        return (UserDatabase.types.get(equalsTracker).equals("Location Employee"));
    }

    /**
     * Updates our Log with current database information (debug & message tracking purposes).
     * Iterates through each list from database and stores entries w/ associated tags.
     */
    private void currentUserDatabase() {
        for (int i = 0; i < UserDatabase.usernames.size(); i++) {
            Log.d("USER", "Username: " + UserDatabase.usernames.get(i));
            Log.d("PASS", "Password: " + UserDatabase.passwords.get(i));
            Log.d("MAIL", "Email: " + UserDatabase.emails.get(i));
        }
    }
}
