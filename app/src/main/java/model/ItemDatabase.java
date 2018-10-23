package model;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ItemDatabase {
//    public static ArrayList<String> times = new ArrayList<>();
//    public static ArrayList<String> locations = new ArrayList<>();
//    public static ArrayList<String> sDesriptions = new ArrayList<>();
//    public static ArrayList<String> fDescriptions = new ArrayList<>();
//    public static ArrayList<String> values = new ArrayList<>();
//    public static ArrayList<String> categories = new ArrayList<>();

    //public static ArrayList<Item> items = new ArrayList<>();
    private List<Item> items;
    public static final ItemDatabase INSTANCE = new ItemDatabase();
    public List<Item> getItems() {
        return items;
    }
    public ItemDatabase() {
        items = new ArrayList<>();
    }

    public Item findItemsAtLocation(String location) {
        for (Item d : items) {
            if (d.getLocation().equals(location)) return d;
        }
        Log.d("MYAPP", "Warning - Failed to find items for: " + location);
        return null;
    }

}


