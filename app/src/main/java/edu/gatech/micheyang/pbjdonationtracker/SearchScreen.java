package edu.gatech.micheyang.pbjdonationtracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.content.Intent;

public class SearchScreen extends AppCompatActivity {

    private EditText item;            // item input
    private Spinner category;         // category spinner
    private Spinner location;         // location spinner
    private Button searchForItem;     // item search button
    private Button searchForCat;      // category search button
    private Button searchForLoc;      // location search button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pressSearchItem();
        pressSearchCat();
        pressSearchLoc();
    }

    /**
     *
     */
    public void pressSearchItem() {
        searchForItem = (Button) findViewById(R.id.itemSearchButton);
        searchForItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent("edu.gatech.micheyang.pbjdonationtracker.AddItemScreen");
                //startActivity(intent);
            }
        });
    }

    /**
     *
     */
    public void pressSearchCat() {
        searchForCat = (Button) findViewById(R.id.catSearchButton);
        searchForCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent("edu.gatech.micheyang.pbjdonationtracker.AddItemScreen");
                //startActivity(intent);
            }
        });
    }

    /**
     *
     */
    public void pressSearchLoc() {
        searchForLoc = (Button) findViewById(R.id.locSearchButton);
        searchForLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent("edu.gatech.micheyang.pbjdonationtracker.AddItemScreen");
                //startActivity(intent);
            }
        });
    }
}
