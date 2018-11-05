package edu.gatech.micheyang.pbjdonationtracker.controllers;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;

import java.util.List;

import edu.gatech.micheyang.pbjdonationtracker.R;
import edu.gatech.micheyang.pbjdonationtracker.db_model.Location;
public class LocationAdapter  extends RecyclerView.Adapter<LocationAdapter.LocationVH> {

    List<Location> locn_list;

    public LocationAdapter(List<Location> locn_list) {
        this.locn_list = locn_list;
    }

    @Override
    public LocationVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.location_list_view, parent, false);
        return new LocationVH(view);
    }

    @Override
    public void onBindViewHolder(LocationVH vh, int position) {
        vh.tvName.setText(locn_list.get(position).getName());
//        vh.setLocationClickListener(new LocationClickListener() {
//            @Override
//            public void onLocationClick(View view, int pos) {
//                Log.d("LocationDetail", "test");
//            }
//        });
    }

    // returns number of locations
    @Override
    public int getItemCount() {
        Log.v(LocationAdapter.class.getSimpleName(), "" + locn_list.size());
        return locn_list.size();
    }

    public class LocationVH extends RecyclerView.ViewHolder {

        public AppCompatTextView tvName;

        public LocationVH(View view) {
            super(view);
            tvName = view.findViewById(R.id.tvName);
        }
    }
}
