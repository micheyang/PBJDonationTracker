package edu.gatech.micheyang.pbjdonationtracker.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import edu.gatech.micheyang.pbjdonationtracker.MainActivity;
import edu.gatech.micheyang.pbjdonationtracker.R;
import model.Location;
import model.LocationList;

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

    public static final int NAME_POSITION = 1;
    public static final int LATITUDE_POSITION = 2;
    public static final int LONGITUDE_POSITION = 3;
    public static final int STREET_ADDRESS_POSITION = 4;
    public static final int CITY_POSITION = 5;
    public static final int STATE_POSITION = 6;
    public static final int ZIP_CODE_POSITION = 7;
    public static final int TYPE_POSITION = 8;
    public static final int PHONE_NUMBER_POSITION = 9;
    public static final int WEBSITE_POSITION = 10;

    private void readCSVFile() {
        model.LocationList model = LocationList.INSTANCE;

        try {
            //Open a stream on the raw file
            InputStream is = getResources().openRawResource(R.raw.locationdata);
            //From here we probably should call a model method and pass the InputStream
            //Wrap it in a BufferedReader so that we get the readLine() method
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

            String line;
            br.readLine(); //get rid of header line
            while ((line = br.readLine()) != null) {
                //Log.d(MainActivity.TAG, line);
                String[] details = line.split(",");
                int key = Integer.parseInt(details[0]);
                model.addLocation(new Location(key, details[NAME_POSITION], details[LATITUDE_POSITION],
                        details[LONGITUDE_POSITION], details[STREET_ADDRESS_POSITION], details[CITY_POSITION],
                        details[STATE_POSITION], details[ZIP_CODE_POSITION], details[TYPE_POSITION],
                        details[PHONE_NUMBER_POSITION], details[WEBSITE_POSITION]));
            }
            br.close();
        } catch (IOException e) {
            //Log.e(MainActivity.TAG, "error reading assets", e);
        }
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