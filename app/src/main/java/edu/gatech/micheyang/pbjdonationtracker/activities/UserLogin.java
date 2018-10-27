package edu.gatech.micheyang.pbjdonationtracker.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.gatech.micheyang.pbjdonationtracker.R;
import edu.gatech.micheyang.pbjdonationtracker.SQLDatabase.DatabaseHelper;


public class UserLogin extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = UserLogin.this;
    private DatabaseHelper dbhelper;

    private EditText inputUsername;
    private EditText inputPassword;
    private Button buttonLogin;
    private Button buttonCancel;
    private TextView failedLogin;













    @Override
    public void onClick(View view) {

    }
}
