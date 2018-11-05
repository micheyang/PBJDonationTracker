package edu.gatech.micheyang.pbjdonationtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import model.Location;
import model.LocationList;
import model.User;

import static edu.gatech.micheyang.pbjdonationtracker.EmployeeAppScreen.CITY_POSITION;
import static edu.gatech.micheyang.pbjdonationtracker.EmployeeAppScreen.LATITUDE_POSITION;
import static edu.gatech.micheyang.pbjdonationtracker.EmployeeAppScreen.LONGITUDE_POSITION;
import static edu.gatech.micheyang.pbjdonationtracker.EmployeeAppScreen.NAME_POSITION;
import static edu.gatech.micheyang.pbjdonationtracker.EmployeeAppScreen.PHONE_NUMBER_POSITION;
import static edu.gatech.micheyang.pbjdonationtracker.EmployeeAppScreen.STATE_POSITION;
import static edu.gatech.micheyang.pbjdonationtracker.EmployeeAppScreen.STREET_ADDRESS_POSITION;
import static edu.gatech.micheyang.pbjdonationtracker.EmployeeAppScreen.TYPE_POSITION;
import static edu.gatech.micheyang.pbjdonationtracker.EmployeeAppScreen.WEBSITE_POSITION;
import static edu.gatech.micheyang.pbjdonationtracker.EmployeeAppScreen.ZIP_CODE_POSITION;

public class LocationEmployee extends AppCompatActivity {

    private Button select;
    private Spinner type;
    private Location loc;
    private ArrayList<Location> temp; //temporary arraylist to load locations so user can select on and assign it to them


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_employee);

        select();
    }

    public void select() {
        type = findViewById(R.id.employeeSelectLocSpinner);
        select = findViewById(R.id.select);

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readCSVFile();
                Log.d("locList", "" + temp);
                String locName = type.getSelectedItem().toString();
                loc = findLocationByName(locName);
                UserDatabase.location.set(UserDatabase.location.size()-1, loc.getKey());
                Log.d("userLocs", "Location keys" + UserDatabase.location);
                Log.d("userLocs", "Users" + UserDatabase.usernames);

                Intent intent = new Intent("edu.gatech.micheyang.pbjdonationtracker.LoginActivity");
                startActivity(intent);

            }
        });
    }
    //method to search by location name  for the temporary list of locations
    public Location findLocationByName(String name) {
        for (Location d : temp) {
            if (d.getName().equals(name)) return d;
        }
        Log.d("MYAPP", "Warning - Failed to find name: " + name);
        return null;
    }

    //use to read and load temporary list of locations for locationemployee
    private void readCSVFile() {
        temp = new ArrayList<>();

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
                temp.add(new Location(key, details[NAME_POSITION], details[LATITUDE_POSITION],
                        details[LONGITUDE_POSITION], details[STREET_ADDRESS_POSITION], details[CITY_POSITION],
                        details[STATE_POSITION], details[ZIP_CODE_POSITION], details[TYPE_POSITION],
                        details[PHONE_NUMBER_POSITION], details[WEBSITE_POSITION]));
            }
            br.close();
        } catch (IOException e) {
            //Log.e(MainActivity.TAG, "error reading assets", e);
        }
    }
}
