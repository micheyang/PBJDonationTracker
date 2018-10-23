package edu.gatech.micheyang.pbjdonationtracker;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import model.Item;
import model.ItemDatabase;

public class ItemDetailFragment extends Fragment {
    public static final String ARG_LOCATION_NAME = "location_name";

    private Item mItem;

    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*if (getArguments().containsKey(ARG_LOCATION_NAME)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            String location_name = getArguments().getString(ARG_LOCATION_NAME);
            Log.d("MYAPP", "Start details for: " + location_name);
            mItem = ItemDatabase.INSTANCE.findItemsAtLocation(location_name);

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getShortDescription());
            }
        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_item_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.time)).setText(getResources().getString(R.string.time, mItem.getTime()));
            ((TextView) rootView.findViewById(R.id.location)).setText(getResources().getString(R.string.place, mItem.getLocation()));
            /*((TextView) rootView.findViewById(R.id.short_desc)).setText(getResources().getString(R.string.website, mItem.getShortDescription()));
            ((TextView) rootView.findViewById(R.id.full_desc).setText(getResources().getString(R.string.longitude, mItem.getFullDescription()));
            ((TextView) rootView.findViewById(R.id.value)).setText(getResources().getString(R.string.latitude, mItem.getValue()));
            ((TextView) rootView.findViewById(R.id.category)).setText(getResources().getString(R.string.address, mItem.getCategory()));*/
            //((TextView) rootView.findViewById(R.id.city)).setText(mItem.getCity());
            //((TextView) rootView.findViewById(R.id.state)).setText(mItem.getState());
            //((TextView) rootView.findViewById(R.id.zip_code)).setText(mItem.getZipCode());
        }

        return rootView;
    }

}
