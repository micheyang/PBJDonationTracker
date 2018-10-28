package edu.gatech.micheyang.pbjdonationtracker.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import edu.gatech.micheyang.pbjdonationtracker.AppScreen;
import edu.gatech.micheyang.pbjdonationtracker.MainActivity;
import edu.gatech.micheyang.pbjdonationtracker.R;
import edu.gatech.micheyang.pbjdonationtracker.database.DatabaseHelper;
import edu.gatech.micheyang.pbjdonationtracker.db_model.User;

public class UserRegistration extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = UserRegistration.this;
    private DatabaseHelper dbhelper;
    private User user;

    private Button regButton;
    private Button cancelButton;

    private EditText username; //username input box
    private EditText email; //email input box
    private EditText password; //password input box

    private Spinner type; //user type dropdown spinner
    private TextView invalid_attempt; //text notification for bad attempt


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        init();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.regCancelButton:
                Log.d("Edit", "cancel register");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                resetFields();
                startActivity(intent);
                break;
            case R.id.regRegButton:
                register();
                break;
        }
    }

    private void init() {
        dbhelper = new DatabaseHelper(activity);
        user = new User();

        username = findViewById(R.id.regNameEntry);
        password = findViewById(R.id.regPassEntry);
        email = findViewById(R.id.regEmailEntry);
        type = findViewById(R.id.regTypeDropDown);
        invalid_attempt = findViewById(R.id.invalidAttempt);

        regButton = findViewById(R.id.regRegButton);
        cancelButton = findViewById(R.id.regCancelButton);
        regButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
    }

    private void resetFields() {
        username.setText(null);
        email.setText(null);
        password.setText(null);
    }

    private void register() {
        Log.d("Edit", "attempt register");
        String usernm = username.getText().toString().trim();
        String eml = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        boolean result = validate(usernm, eml);
        if (!result) {
            addUser(usernm, eml, pass);
            Intent intent = new Intent(getApplicationContext(), UserLogin.class);
            resetFields();
            startActivity(intent);

        } else {
            invalid_attempt.setVisibility(View.VISIBLE);
        }
    }

    private boolean validate(String usernm, String eml) {
        if (usernm == null || eml == null) {
            return false;
        }
        return (dbhelper.checkUsername(usernm) || dbhelper.checkEmail(eml));
    }

    private void addUser(String usernm, String eml, String pass) {
        if (usernm == null || eml == null || pass == null) {
            Log.d("Database", "failure: null user data");
            return;
        }
        user.setUsername(usernm);
        user.setEmail(eml);
        user.setPassword(pass);
        user.setLocked(false);
        dbhelper.addUser(user);
        Log.d("Database", "success: added user");
    }

}
