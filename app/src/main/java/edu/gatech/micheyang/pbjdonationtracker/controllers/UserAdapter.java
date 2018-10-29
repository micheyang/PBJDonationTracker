package edu.gatech.micheyang.pbjdonationtracker.controllers;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import edu.gatech.micheyang.pbjdonationtracker.R;
import edu.gatech.micheyang.pbjdonationtracker.db_model.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserVH> {

    private List<User> user_list;

    public UserAdapter(List<User> user_list) {
        this.user_list = user_list;
    }

    @Override
    public UserVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_list_view, parent, false);
        return new UserVH(view);
    }


    @Override
    public void onBindViewHolder(UserVH vh, int position) {
        vh.tvUsername.setText(user_list.get(position).getUsername());
        vh.tvEmail.setText(user_list.get(position).getEmail());
        vh.tvPassword.setText(user_list.get(position).getPassword());
        vh.tvLocked.setText(String.valueOf(user_list.get(position).getLocked()));
    }

    @Override
    public int getItemCount() {
        Log.v(UserAdapter.class.getSimpleName(), "" + user_list.size());
        return user_list.size();
    }

    public class UserVH extends RecyclerView.ViewHolder {

        public AppCompatTextView tvUsername;
        public AppCompatTextView tvEmail;
        public AppCompatTextView tvPassword;
        public AppCompatTextView tvLocked;

        public UserVH(View view) {
            super(view);
            tvUsername = view.findViewById(R.id.tvUsername);
            tvEmail = view.findViewById(R.id.tvEmail);
            tvPassword = view.findViewById(R.id.tvPassword);
            tvLocked = view.findViewById(R.id.tvLocked);
        }
    }

}
