package edu.gatech.micheyang.pbjdonationtracker.activities;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.micheyang.pbjdonationtracker.R;
import edu.gatech.micheyang.pbjdonationtracker.controllers.LocationAdapter;
import edu.gatech.micheyang.pbjdonationtracker.database.LocationDBHelper;
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
        setContentView(R.layout.db_location_list);
        init();
    }

    private void init() {
        recyclerView = findViewById(R.id.locnRecyclerView);
        list = new ArrayList<>();
        adapter = new LocationAdapter(list);
        dbhelper = new LocationDBHelper(activity);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(lm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        dbhelper = new LocationDBHelper(activity);

        populate();

    }

    @SuppressLint("StaticFieldLeak")
    private void populate() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                list.clear();
                list.addAll(dbhelper.locationList());
                return null;
            }
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                adapter.notifyDataSetChanged();
            }
        }.execute();
    }
}
