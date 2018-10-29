package edu.gatech.micheyang.pbjdonationtracker.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import edu.gatech.micheyang.pbjdonationtracker.MainActivity;
import edu.gatech.micheyang.pbjdonationtracker.R;
import edu.gatech.micheyang.pbjdonationtracker.database.DatabaseHelper;
import edu.gatech.micheyang.pbjdonationtracker.db_model.User;

public class UserRegistration extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = UserRegistration.this;
    private static Context context;
    private DatabaseHelper dbhelper;
    private User user;

    private Button regButton;
    private Button cancelButton;

    private EditText username; //username input box
    private EditText email; //email input box
    private EditText password; //password input box

    private Spinner typeDropDown; //user type dropdown spinner
    private TextView invalid_attempt; //text notification for bad attempt


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        context = this;
        init();
        listeners();
        spinner();
        objects();
    }

    private void init() {
        username = findViewById(R.id.regNameEntry);
        password = findViewById(R.id.regPassEntry);
        email = findViewById(R.id.regEmailEntry);
        invalid_attempt = findViewById(R.id.invalidAttempt);
        typeDropDown = findViewById(R.id.regTypeDropDown);
        regButton = findViewById(R.id.regRegButton);
        cancelButton = findViewById(R.id.regCancelButton);
    }

    private void listeners() {
        regButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);
    }

    private void spinner() {
        int index = typeDropDown.getSelectedItemPosition();
        Resources res = getResources();
        String[] strTypes = res.getStringArray(R.array.acctTypes);
        String type = User.types.get(index);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.regCancelButton:
                Log.d("Edit", "cancel register");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;
            case R.id.regRegButton:
                register();
                break;
        }
    }



    private void objects() {
        dbhelper = new DatabaseHelper(activity);
        user = new User();
    }

    private void register() {
        Log.d("Edit", "attempt register");
        String usernm = username.getText().toString().trim();
        String eml = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        int index = typeDropDown.getSelectedItemPosition();
        String type = User.getTypeFromSelected(index);

        boolean result = validate(usernm, eml);
        if (!result) {
            addtoDB(usernm, eml, pass, type);
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

    private void addtoDB(String usernm, String eml, String pass, String acctType) {
        if (usernm == null || eml == null || pass == null) {
            Log.d("Database", "failure: null user data");
            return;
        }
        user.setUsername(usernm);
        user.setEmail(eml);
        user.setPassword(pass);
        user.setLocked(false);
        user.setType(User.types.get(User.findTypeIndex(acctType)));
        dbhelper.addUser(user);
        Log.d("Database", "success: added user");
    }

    private void resetFields() {
        username.setText(null);
        email.setText(null);
        password.setText(null);
    }

    public static Context getContext() {
        return context;
    }
}
