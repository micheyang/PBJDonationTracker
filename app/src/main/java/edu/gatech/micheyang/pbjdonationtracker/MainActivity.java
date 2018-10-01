package edu.gatech.micheyang.pbjdonationtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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


//    /***
//     * The method called when a user requests to log-in to application w/ "LOGIN"
//     *
//     * @param view the selected view
//     */
//    public void onLoginPressed(View view) {
//        Log.d("Edit", "Log in");
//        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//        startActivity(intent);
//    }
//
//    /***
//     * The method called when a user requests to make a new account w/ "REGISTER"
//     *
//     * @param view the selected view
//     */
//    public void onRegisterPressed(View view) {
//        Log.d("Edit", "Log in");
//        Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
//        startActivity(intent);
//    }
//}
