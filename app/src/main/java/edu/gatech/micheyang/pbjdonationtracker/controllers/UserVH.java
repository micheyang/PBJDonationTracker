package edu.gatech.micheyang.pbjdonationtracker.controllers;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import edu.gatech.micheyang.pbjdonationtracker.R;

public class UserVH extends RecyclerView.ViewHolder {

    public TextView username;
    public TextView email;
    public TextView password;

    public UserVH(View itemView) {
        super(itemView);
        username = itemView.findViewById(R.id.tvUsername);
        email = itemView.findViewById(R.id.tvEmail);
        password = itemView.findViewById(R.id.tvPassword);
    }
}
