 package edu.gatech.micheyang.pbjdonationtracker;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
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

        register(); //handles user registration attempt
        cancel(); //handles user cancelled attempt
    }

    public void register() {
        Log.d("Edit", "attempt register");
        username = (EditText) findViewById(R.id.regNameEntry);
        email = (EditText) findViewById(R.id.regEmailEntry);
        password = (EditText) findViewById(R.id.regPassEntry);
        type = (Spinner) findViewById(R.id.regTypeDropDown);
        invalid_attempt = (TextView) findViewById(R.id.invalidAttempt);

        //a regButton click will check user's inputs for in/valid attempt
        regButton = (Button) findViewById(R.id.regRegButton);
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validate(username.getText().toString(),
                        password.getText().toString(), email.getText().toString())) {
                    invalid_attempt.setVisibility(View.VISIBLE);
                } else { //registration success, add user's info into database lists
                    Intent intent = new Intent("edu.gatech.micheyang.pbjdonationtracker.LoginActivity");
                    UserDatabase.usernames.add(username.getText().toString());
                    UserDatabase.passwords.add(password.getText().toString());
                    UserDatabase.emails.add(email.getText().toString());
                    UserDatabase.types.add(type.getSelectedItem().toString());
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

    /**
     * Checks user inputs: valid attempt if username doesn't already exist in database.
     *
     * @param _username the user's username input
     * @param _password the user's password input
     * @param _email    the user's email address input
     * @return true if user doesn't use existing username, false if duplicate username
     */
    private boolean validate(String _username, String _password, String _email) {
        return !UserDatabase.usernames.contains(_username) && !UserDatabase.emails.contains(_email);
    }

}