package edu.gatech.micheyang.pbjdonationtracker.activities;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.micheyang.pbjdonationtracker.R;
import edu.gatech.micheyang.pbjdonationtracker.controllers.LocationAdapter;
import edu.gatech.micheyang.pbjdonationtracker.database.LocationDBHelper;
import edu.gatech.micheyang.pbjdonationtracker.db_model.Location;

public class LocationList extends AppCompatActivity {

    private AppCompatActivity activity = LocationList.this;
    private RecyclerView recyclerView;
//    private LocationAdapter adapter;
//    private LocationDBHelper dbhelper;
    private List<Location> list;
    private Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_db_list);
        init();
    }

    private void init() {
        recyclerView = findViewById(R.id.locnRecyclerView);
        list = new ArrayList<>();
//        adapter = new LocationAdapter(list);

//        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(lm);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setAdapter(adapter);

//        dbhelper = new LocationDBHelper(activity);
    }
}
