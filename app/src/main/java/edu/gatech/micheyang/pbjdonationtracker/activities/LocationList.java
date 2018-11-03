package edu.gatech.micheyang.pbjdonationtracker.activities;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.micheyang.pbjdonationtracker.R;
import edu.gatech.micheyang.pbjdonationtracker.controllers.LocationAdapter;
import edu.gatech.micheyang.pbjdonationtracker.database.LocationDBHelper;
import edu.gatech.micheyang.pbjdonationtracker.db_model.Item;
import edu.gatech.micheyang.pbjdonationtracker.db_model.Location;

public class LocationList extends AppCompatActivity {

    private AppCompatActivity activity = LocationList.this;
    private RecyclerView recyclerView;
    private LocationAdapter adapter;
    private LocationDBHelper dbhelper;
    private List<Location> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_db_list);
        init();
    }

    private void init() {
        recyclerView = findViewById(R.id.locnRecyclerView);
        list = new ArrayList<>();
        adapter = new LocationAdapter(list);

        list = new ArrayList<>();

        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(lm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        readLocationData();
        dbhelper = new LocationDBHelper(activity);

    }

    private void readLocationData() {
        InputStream is = getResources().openRawResource(R.raw.locationdata);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is,
                Charset.forName("UTF-8")));
        String str = "";
        try {
            while ((str = reader.readLine()) != null) {
                String[] tokens = str.split(",");
                Location loc = new Location();
                loc.setKey(Integer.parseInt(tokens[0]));
                loc.setName(tokens[1]);
                loc.setLatitude(tokens[2]);
                loc.setLongitude(tokens[3]);
                loc.setStreetAddress(tokens[4]);
                loc.setCity(tokens[5]);
                loc.setState(tokens[6]);
                loc.setZipCode(tokens[7]);
                loc.setType(tokens[8]);
                loc.setPhoneNumber(tokens[9]);
                loc.setWebsite(tokens[10]);
                list.add(loc);
                Log.d("LocationList", "added location: " + loc.getName());
            }
            reader.close();
        } catch (IOException ex1) {
            Log.e("LocationList", "Error reading" + str, ex1);
        }
    }




}
