package model;

import java.util.ArrayList;
import java.util.List;

public class LocationList {
    public static final LocationList INSTANCE = new LocationList();

    private List<Location> locations;

    private LocationList() {
        locations = new ArrayList<>();
    }

    public void addLocation(Location location) {
        locations.add(location);
    }

    public List<Location> getItems() {
        return locations;
    }

    //Below method may be needed in the future to search by location IDs
    /*public Location findLocationById(int id) {
        for (Location d : locations) {
            if (d.getId() == id) return d;
        }
        Log.d("MYAPP", "Warning - Failed to find id: " + id);
        return null;
    }*/
}
