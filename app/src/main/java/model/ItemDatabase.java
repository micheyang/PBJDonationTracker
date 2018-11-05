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

//    public Item findItemsAtLocation(String location) {
//        for (Item d : items) {
//            if (d.getLocation().equals(location)) return d;
//        }
//        Log.d("MYAPP", "Warning - Failed to find items for: " + location);
//        return null;
//    }
    public ArrayList<Item> findItemsAtLocation(String location) {
        ArrayList<Item> itemsAtLoc = new ArrayList<>();
        for (Item d : items) {
            if (d.getLocation().equals(location)) itemsAtLoc.add(d);
        }
        Log.d("MYAPP", "Warning - Failed to find items for: " + location);
        return itemsAtLoc;
    }
    public Item getItem(int index) {
        return items.get(index);
    }
    public Item findItemsByKey(int key) {
        for (Item d : items) {
            if (d.getKey() == key) return d;
        }
        Log.d("MYAPP", "Warning - Failed to find items for: " + key);
        return null;
    }

    public ArrayList<Item> findItemsByCategory(String category, String location) {
        ArrayList<Item> itemsInCat = new ArrayList<>();
        if (location.equals("All locations")) {
            for (Item d : items) {
                if (d.getCategory().equals(category)) itemsInCat.add(d);
            }
            Log.d("MYAPP", "Warning - Failed to find items for: " + category
            + " at all locations");
        } else {
            ArrayList<Item> itemsAtLoc = findItemsAtLocation(location);
            for (Item d: itemsAtLoc) {
                if (d.getCategory().equals(category)) itemsInCat.add(d);
            }
            Log.d("MYAPP", "Warning - Failed to find items for: " + category);
        }
        return itemsInCat;
    }

    public ArrayList<Item> findItemsByName(String name, String location) {
        ArrayList<Item> itemsName = new ArrayList<>();
        if (location.equals("All locations")) {
            for (Item d : items) {
                if (d.getShortDescription().contains(name)) itemsName.add(d);
            }
            Log.d("MYAPP", "Warning - Failed to find items for: " + name
                    + " at all locations");
        } else {
            ArrayList<Item> itemsAtLoc = findItemsAtLocation(location);
            for (Item d: itemsAtLoc) {
                if (d.getShortDescription().contains(name)) itemsName.add(d);
            }
            Log.d("MYAPP", "Warning - Failed to find items for: " + name);
        }
        return itemsName;
    }

}


