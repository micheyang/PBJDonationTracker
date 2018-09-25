package edu.gatech.micheyang.pbjdonationtracker;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class AppScreen extends AppCompatActivity {

    /***
     * Method that creates the activity when it is launched.
     *
     * @param savedInstanceState the saved instanced state/null (if nothing saved)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    /***
     * The method called when user attempts to log out of application w/ "Logout".
     * After logging out, the user is taken back to the welcome screen. The user
     * is shown a brief pop-up notification that confirms the user has logged out.
     *
     * @param view the selected view
     */
    public void onLogOutPressed(View view) {
        Log.d("Edit", "logged out");
        Intent intent = new Intent(AppScreen.this, MainActivity.class);
        startActivity(intent);
        //pop-up message notifying user that logout was successful
        Toast toast = Toast.makeText(getBaseContext(), "Logout successful!",
                Toast.LENGTH_SHORT);
        View toastView = toast.getView();
        //setting the color of notification's background bubble
        toastView.getBackground().setColorFilter(Color.parseColor("#daeff1"),
                PorterDuff.Mode.SRC);
        toast.show();
    }
}
