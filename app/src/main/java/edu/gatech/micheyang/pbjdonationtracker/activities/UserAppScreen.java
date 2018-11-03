package edu.gatech.micheyang.pbjdonationtracker.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import edu.gatech.micheyang.pbjdonationtracker.MainActivity;
import edu.gatech.micheyang.pbjdonationtracker.R;

public class UserAppScreen extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = UserAppScreen.this;

    private Button logOutButton;
    private Button searchButton;
    private Button viewButton;


    /***
     * Method that creates the activity when it is launched.
     *
     * @param savedInstanceState the saved instanced state/null (if nothing saved)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_app_screen);

        init();
    }

    /**
     * Method that initializes the objects, views, and listeners.
     */
    private void init() {
        logOutButton = findViewById(R.id.logOutButton);
        searchButton = findViewById(R.id.searchButton);
        viewButton = findViewById(R.id.viewLocnButton);

        logOutButton.setOnClickListener(this);
        searchButton.setOnClickListener(this);
        viewButton.setOnClickListener(this);
    }

    /**
     * Handles button presses. Links the clicked button with its appropriate method.
     */
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.logOutButton:
                logout();
                break;
            case R.id.searchButton:
                search_item();
                break;
            case R.id.viewLocnButton:
                view_locations();
                break;
        }
    }

    /***
     * The method called when user attempts to log out on button press with "LOGOUT".
     * After logging out, the user is taken back to the welcome screen. The user
     * is shown a brief pop-up notification that confirms the user has logged out.
     */
    private void logout() {
        Log.d("ATTEMPT", "logout");
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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

    private void search_item() {
        Log.d("ATTEMPT", "search item");
        Intent intent = new Intent("edu.gatech.micheyang.pbjdonationtracker.SearchScreen");
        startActivity(intent);
    }

    private void view_locations() {
        Log.d("ATTEMPT", "view locations");
        Intent intent = new Intent();
    }


//    /***
//     * The method called when user attempts to log out of application w/ "Logout".
//     * After logging out, the user is taken back to the welcome screen. The user
//     * is shown a brief pop-up notification that confirms the user has logged out.
//     *
//     * @param view the selected view
//     */
//    public void onLogOutPressed(View view) {
//        Log.d("Edit", "logged out");
//        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//        startActivity(intent);
//        //pop-up message notifying user that logout was successful
//        Toast toast = Toast.makeText(getBaseContext(), "Logout successful!",
//                Toast.LENGTH_SHORT);
//        View toastView = toast.getView();
//        //setting the color of notification's background bubble
//        toastView.getBackground().setColorFilter(Color.parseColor("#daeff1"),
//                PorterDuff.Mode.SRC);
//        toast.show();
//    }

}

//    ** FOR ADMIN USE ONLY NOW **
//    private void pressDB() {
//        viewDatabaseButton = findViewById(R.id.buttonDB);
//        viewDatabaseButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), UserList.class);
//                startActivity(intent);
//            }
//        });
//    }