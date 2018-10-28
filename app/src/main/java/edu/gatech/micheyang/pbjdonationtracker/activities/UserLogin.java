package edu.gatech.micheyang.pbjdonationtracker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.gatech.micheyang.pbjdonationtracker.AppScreen;
import edu.gatech.micheyang.pbjdonationtracker.MainActivity;
import edu.gatech.micheyang.pbjdonationtracker.R;
import edu.gatech.micheyang.pbjdonationtracker.database.DatabaseHelper;


public class UserLogin extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = UserLogin.this;
    private DatabaseHelper dbhelper;

    private EditText inputUsername;
    private EditText inputPassword;
    private Button buttonLogin;
    private Button buttonCancel;
    private TextView failedLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        init();
    }

    private void init() {
        dbhelper = new DatabaseHelper(activity);

        inputUsername = findViewById(R.id.enterLoginUsername);
        inputPassword = findViewById(R.id.enterLoginPassword);

        failedLogin = findViewById(R.id.invalidNotification);

        buttonLogin = findViewById(R.id.buttonLogin);
        buttonCancel = findViewById(R.id.buttonCancelLogin);
        buttonLogin.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.buttonCancelLogin:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                resetFields();
                startActivity(intent);
                break;
            case R.id.buttonLogin:
                validate();
                break;
        }
    }

    private void validate() {
        String username = inputUsername.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();
        if (dbhelper.checkUserPass(username, password)) {
            Intent intent = new Intent(getApplicationContext(), AppScreen.class);
            resetFields();
            startActivity(intent);
        } else {
            failedLogin.setVisibility(View.VISIBLE);
        }
    }

    private void resetFields() {
        inputUsername.setText(null);
        inputPassword.setText(null);
    }
}
