package edu.gatech.micheyang.pbjdonationtracker.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import edu.gatech.micheyang.pbjdonationtracker.R;
import edu.gatech.micheyang.pbjdonationtracker.database.DatabaseHelper;
import edu.gatech.micheyang.pbjdonationtracker.database.LocationDBHelper;
import edu.gatech.micheyang.pbjdonationtracker.db_model.Location;
import edu.gatech.micheyang.pbjdonationtracker.db_model.User;


public class EmployeeSelectScreen extends AppCompatActivity {

    private final AppCompatActivity activity = EmployeeSelectScreen.this;

    private Button select;
    private Spinner locationSpin;
    private Location loc;
    private User user;

    private LocationDBHelper dbhelper;
    private DatabaseHelper userDBhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_select_screen);
        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("newLocEmpReg");

        init();
        selectListener();
    }

    private void init() {
        select = findViewById(R.id.buttonSelect);
        dbhelper = new LocationDBHelper(activity);
        userDBhelper = new DatabaseHelper(activity);
        loc = new Location();
    }

    private void spinnerAdapter() {
        locationSpin = findViewById(R.id.selectLocSpinner);
        String[] spinEntries;
        if (dbhelper.isEmpty()) {
            List<Location> spinList = populate();
            spinEntries = new String[spinList.size()];
            for (int i = 0; i < spinList.size(); i++) {
                spinEntries[i] = spinList.get(i).getName();
            }
        } else {
            List<Location> spinList = dbhelper.locationList();
            spinEntries = new String[spinList.size()];
            for (int i = 0; i < spinList.size(); i++) {
                spinEntries[i] = spinList.get(i).getName();
            }
        }

        ArrayAdapter<String> spinAdapt = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, spinEntries);
        spinAdapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpin.setAdapter(spinAdapt);

//        ArrayAdapter<CharSequence> spAdapter = ArrayAdapter.createFromResource(
//                EmployeeSelectScreen.this, R.array.allLocations,
//                android.R.layout.simple_spinner_item);
//        spAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        locationSpin.setAdapter(spAdapter);
//        if (locStr != null) {
//            int pos = spAdapter.getPosition(locStr);
//            locationSpin.setSelection(pos);
//            return pos;
//
    }

    public void selectListener() {
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinnerAdapter();
                String locationString = locationSpin.getSelectedItem().toString();
                loc = findLocationByName(locationString);
                List<User> curr = loc.getEmployeeList();
                if (curr.add(user)) {
                    loc.setEmployeeList(curr);
                }
                user.setEmpId(loc.getKey());
                userDBhelper.updateUser(user);
                Intent intent = new Intent(getApplicationContext(), UserLogin.class);
                startActivity(intent);
                Toast toast = Toast.makeText(getBaseContext(), "Registration successful!",
                        Toast.LENGTH_SHORT);
                View toastView = toast.getView();
                //setting the color of notification's background bubble
                toastView.getBackground().setColorFilter(Color.parseColor("#daeff1"),
                        PorterDuff.Mode.SRC);
                toast.show();

            }
        });
    }
    //method to search by location name  for the temporary list of locations
    public Location findLocationByName(String name) {
        List<Location> locnList = dbhelper.locationList();
        for (Location d : locnList) {
            if (d.getName().equals(name)) return d;
        }
        Log.d("MYAPP", "Warning - Failed to find name: " + name);
        return locnList.get(0);
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

    // populate with csv file location data
    public List<Location> populate() {
        List <Location> temp = new ArrayList<>();

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
                Location locn = new Location();
                String[] details = line.split(",");
                locn.setKey(Integer.parseInt(details[0]));
                locn.setName(details[NAME_POSITION]);
                locn.setLatitude(details[LATITUDE_POSITION]);
                locn.setLongitude(details[LONGITUDE_POSITION]);
                locn.setStreetAddress(details[STREET_ADDRESS_POSITION]);
                locn.setCity(details[CITY_POSITION]);
                locn.setState(details[STATE_POSITION]);
                locn.setZipCode(details[ZIP_CODE_POSITION]);
                locn.setType(details[TYPE_POSITION]);
                locn.setPhoneNumber(details[PHONE_NUMBER_POSITION]);
                locn.setWebsite(details[WEBSITE_POSITION]);
                dbhelper.addLocation(locn);
                temp.add(locn);
//                int key = Integer.parseInt(details[0]);
//                temp.add(new Location(key, details[NAME_POSITION], details[LATITUDE_POSITION],
//                        details[LONGITUDE_POSITION], details[STREET_ADDRESS_POSITION], details[CITY_POSITION],
//                        details[STATE_POSITION], details[ZIP_CODE_POSITION], details[TYPE_POSITION],
//                        details[PHONE_NUMBER_POSITION], details[WEBSITE_POSITION]));
            }
            br.close();
        } catch (IOException e) {
            //Log.e(MainActivity.TAG, "error reading assets", e);
        }
        return temp;
    }
}
