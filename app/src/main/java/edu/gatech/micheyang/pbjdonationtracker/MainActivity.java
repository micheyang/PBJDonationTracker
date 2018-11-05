package edu.gatech.micheyang.pbjdonationtracker;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

import edu.gatech.micheyang.pbjdonationtracker.activities.UserLogin;
import edu.gatech.micheyang.pbjdonationtracker.activities.UserRegistration;
import edu.gatech.micheyang.pbjdonationtracker.database.DatabaseHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = MainActivity.this;
    private DatabaseHelper dbhelper;

    private Button logButton;
    private Button regButton;

    /***
     * Method that creates the activity when it is launched.
     *
     * @param savedInstanceState the saved instanced state/null (if nothing saved)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        dbhelper = new DatabaseHelper(activity);
        logButton = findViewById(R.id.login);
        regButton = findViewById(R.id.register);
        logButton.setOnClickListener(this);
        regButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                Intent intent = new Intent(getApplicationContext(), UserLogin.class);
                startActivity(intent);
                break;
            case R.id.register:
                Intent intent_r = new Intent(getApplicationContext(), UserRegistration.class);
                startActivity(intent_r);
                break;
        }
    }
//    /**
//     * Method to handle a login-button press, directs the user to Login screen.
//     */
//    public void pressLogin() {
//        logButton = (Button) findViewById(R.id.login);
//        logButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), UserLogin.class);
//                startActivity(intent);
//            }
//        });
//    }
//
//    /**
//     * Method to handle a register-button press, directs user to Registration screen.
//     */
//    public void pressRegister() {
//        regButton = (Button) findViewById(R.id.register);
//        regButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), UserRegistration.class);
//                startActivity(intent);
//            }
//        });
//
//    }

}
