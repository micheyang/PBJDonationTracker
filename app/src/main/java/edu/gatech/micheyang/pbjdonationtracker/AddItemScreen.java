package edu.gatech.micheyang.pbjdonationtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import model.Item;
import model.ItemDatabase;


public class AddItemScreen extends AppCompatActivity {

    private EditText time;
//    private EditText location;
    private EditText shortDescription;
    private EditText fullDescription;
    private EditText value;
    private Spinner category;

    private Button addButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        add();
        cancel();
    }
    public void add() {
        time = (EditText) findViewById(R.id.enterDonateDate);
//        location =
        shortDescription= (EditText) findViewById(R.id.enterShortDescr);
        fullDescription = (EditText) findViewById(R.id.enterFullDescr);
        value = (EditText) findViewById(R.id.enterItemValue);
        category = (Spinner) findViewById(R.id.selectItemCategory);

        addButton = (Button) findViewById(R.id.addItemButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("edu.gatech.micheyang.pbjdonationtracker.EmployeeAppScreen"); //change to item list screen
//                ItemDatabase.times.add(time.getText().toString());
//                ItemDatabase.locations.add(null);  //need to change this
//                ItemDatabase.sDesriptions.add(shortDescription.getText().toString());
//                ItemDatabase.fDescriptions.add(fullDescription.getText().toString());
//                ItemDatabase.values.add(value.getText().toString());
//                ItemDatabase.categories.add(category.getSelectedItem().toString());
                ItemDatabase.items.add(new Item(time.getText().toString(), "default location",
                        shortDescription.getText().toString(), fullDescription.getText().toString(),
                        value.getText().toString(), category.getSelectedItem().toString()));
                currentItemDatabase();
                startActivity(intent);

            }
        });
    }

    public void cancel() {
        Log.d("Cancel", "cancel register");
        cancelButton = (Button) findViewById(R.id.cancelItemButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("edu.gatech.micheyang.pbjdonationtracker.EmployeeAppScreen");
                startActivity(intent);
            }
        });
    }

    private void currentItemDatabase() {
        for (int i = 0; i < ItemDatabase.items.size(); i++) {
            Log.d("Item", "Item: " + ItemDatabase.items.get(i));

        }
    }
}
