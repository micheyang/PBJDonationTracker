package edu.gatech.micheyang.pbjdonationtracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;

public class SearchScreen extends AppCompatActivity {

    private Button cancelButton;
    private Button itemSearchButton;
    private Button catSearchButton;
    private Button locSearchButton;
    private EditText item;
    private Spinner category;
    private Spinner location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        pressCancel();
        pressItemSearch();
        pressCatSearch();
        pressLocSearch();
    }

    // Go back to AppScreen or EmplyeeAppScreen depending on current UserIndex
    public void pressCancel() {
        cancelButton = (Button) findViewById(R.id.cancelSearchButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("edu.gatech.micheyang.pbjdonationtracker.AppScreen");
                startActivity(intent);
            }
        });
    }

    public void pressItemSearch() {
        itemSearchButton = (Button) findViewById(R.id.itemSearchButton);
    }

    public void pressCatSearch() {
        catSearchButton = (Button) findViewById(R.id.catSearchButton);
    }

    public void pressLocSearch() {
        locSearchButton = (Button) findViewById(R.id.locSearchButton);
    }
}
