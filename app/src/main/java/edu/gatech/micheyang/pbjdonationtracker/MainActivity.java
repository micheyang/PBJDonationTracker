package edu.gatech.micheyang.pbjdonationtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

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
        pressLogin();
        pressRegister();
    }

    /**
     * Method to handle a login-button press, directs the user to Login screen.
     */
    public void pressLogin() {
        logButton = (Button) findViewById(R.id.login);
        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("edu.gatech.micheyang.pbjdonationtracker.LoginActivity");
                startActivity(intent);
            }
        });
    }

    /**
     * Method to handle a register-button press, directs user to Registration screen.
     */
    public void pressRegister() {
        regButton = (Button) findViewById(R.id.register);
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("edu.gatech.micheyang.pbjdonationtracker.RegistrationActivity");
                startActivity(intent);
            }
        });

    }
}
