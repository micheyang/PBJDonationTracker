package edu.gatech.micheyang.pbjdonationtracker.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.micheyang.pbjdonationtracker.AppScreen;
import edu.gatech.micheyang.pbjdonationtracker.R;
import edu.gatech.micheyang.pbjdonationtracker.controllers.UserAdapter;
import edu.gatech.micheyang.pbjdonationtracker.database.DatabaseHelper;
import edu.gatech.micheyang.pbjdonationtracker.db_model.User;


public class UserList extends AppCompatActivity {

    private AppCompatActivity activity = UserList.this;
    private RecyclerView recyclerView;
    private UserAdapter adapter;
    private DatabaseHelper dbhelper;
    private List<User> list;
    private Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        init();
    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        adapter = new UserAdapter(list);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(lm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        dbhelper = new DatabaseHelper(activity);

        exit = findViewById(R.id.exitButton);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AppScreen.class);
                startActivity(intent);
            }
        });
        populate();
    }


    @SuppressLint("StaticFieldLeak")
    private void populate() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                list.clear();
                list.addAll(dbhelper.userList());
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
