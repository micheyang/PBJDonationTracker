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
import android.widget.Spinner;


public class RegistrationActivity extends AppCompatActivity {

    private EditText username; //username input box
    private EditText email; //email input box
    private EditText password; //password input box
    private Spinner type; //user type dropdown spinner
    private TextView invalid_attempt; //text notification for bad attempt
    private Button regButton; //register button
    private Button cancelButton; //cancel button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        register();
        cancel();
    }

    public void register() {
        Log.d("Edit", "attempt register");
        username = (EditText) findViewById(R.id.regNameEntry);
        email = (EditText) findViewById(R.id.regEmailEntry);
        password = (EditText) findViewById(R.id.regPassEntry);
        type = (Spinner) findViewById(R.id.regTypeDropDown);
        invalid_attempt = (TextView) findViewById(R.id.invalidAttempt);

        regButton = (Button) findViewById(R.id.regRegButton);
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validate(username.getText().toString(),
                        password.getText().toString(), email.getText().toString())) {
                    invalid_attempt.setVisibility(View.VISIBLE);
                } else {
                    Intent intent = new Intent("edu.gatech.micheyang.pbjdonationtracker.LoginActivity");
                    UserDatabase.usernames.add(username.getText().toString());
                    UserDatabase.passwords.add(password.getText().toString());
                    UserDatabase.emails.add(email.getText().toString());
                    UserDatabase.types.add(type.getSelectedItem().toString());
//                    Intent intent = new Intent("edu.gatech.micheyang.pbjdonationtracker.LoginActivity");
                    startActivity(intent);
                }
            }
        });
    }

    public void cancel() {
        Log.d("Edit", "cancel register");
        cancelButton = (Button) findViewById(R.id.regCancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.MainActivity");
                startActivity(intent);
            }
        });
    }
    private boolean validate(String _username, String _password, String _email) {
        return !UserDatabase.usernames.contains(_username) && !UserDatabase.emails.contains(_email);
    }

    private void addUser(String _username, String _email, String _password, String _type) {
        UserDatabase.usernames.add(_username);
        UserDatabase.emails.add(_email);
        UserDatabase.passwords.add(_password);
        UserDatabase.types.add(_type);
    }
}

//    public void onRegButtonPressed(View view) {
//        Log.d("Edit", "Registered");
//
//        // Check if new user should be accepted/added to system here
//        int id = validate(username.getText().toString(), email.getText().toString(),
//                password.getText().toString(), userType);
//        if (id == 0) {
//            //null input strings- notify user that 1 or more inputs missing
//        } else if (id == 1) {
//            //username exists already in system
//            invalid_attempt.setVisibility(View.VISIBLE);
//        } else {
//            User user = new User(username.getText().toString(), password.getText().toString(),
//                    email.getText().toString(), userType);
//            Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
//            startActivity(intent); //go login
//        }
//
//    }
//
//    public int validate(String user, String email, String pass, String type) {
//        if (user == null || email == null || pass == null) { return 0; }
////        if (users.containsUser(user)) { return 1; }
//        return 2;
//    }
//
//
//    /**
//     * The method called when the user cancels/backs out of registering w/ "Cancel"
//     *
//     * @param view the selected view
//     */
//    public void onCancelPressed(View view) {
//        Log.d("Edit", "canceled");
//        Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
//        startActivity(intent);
//    }
//
//}
