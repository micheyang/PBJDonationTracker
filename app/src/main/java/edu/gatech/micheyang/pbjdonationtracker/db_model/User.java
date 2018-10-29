package edu.gatech.micheyang.pbjdonationtracker.db_model;

import android.content.res.Resources;
import android.content.Context;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.gatech.micheyang.pbjdonationtracker.R;
import edu.gatech.micheyang.pbjdonationtracker.activities.UserRegistration;

public class User {

    private int id;
    private String username;
    private String password;
    private String email;
    private boolean locked = false;
    private String type = types.get(0);

    private Context context;

    /**
     * GETTERS AND SETTERS FOR EACH ATTRIBUTE
     */
    public static List<String> types = Arrays.asList("USER", "EMPLOYEE", "MANAGER", "ADMIN");

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getType() { return type; }

    public void setType(String type) {
        if (!(types.contains(type))) {
            this.type = types.get(0);
        } else {
            this.type = type;
        }
    }

    public static int findTypeIndex(String str) {
        int i = 0;
        while (i < types.size()) {
            if (str.equals(types.get(i))) {
                return i;
            }
            i++;
        }
        return 0;
    }

    public static Map<String, String> getTypeMap() {
        // maps acctType dropdown entries to Strings in types list
        Map<String, String> map = new HashMap<>();

        Context context = UserRegistration.getContext();
        Resources res = context.getResources();
        String[] strTypes = res.getStringArray(R.array.acctTypes);

        for (int i = 0; i < types.size(); i++) {
            String s = strTypes[i];
            switch (s) {
                case "Location Employee":
                    map.put(types.get(1), s);
                    break;
                case "Manager":
                    map.put(types.get(2), s);
                    break;
                case "Administrator":
                    map.put(types.get(3), s);
                    break;
                default:
                    map.put(types.get(0), s);
                    break;
            }
        }
        return map;
    }

    public static String getTypeFromSelected(int position) {
        // if invalid index, set to default type as general user
        if (position >= types.size() || position < 0) { return types.get(0); }
        Context context = UserRegistration.getContext();
        Resources res = context.getResources();
        String[] strTypes = res.getStringArray(R.array.acctTypes);
        String s = strTypes[position];
        String result;
        switch (s) {
            case "Location Employee":
                result = types.get(1);
                break;
            case "Manager":
                result = types.get(1);
                break;
            case "Administrator":
                result = types.get(3);
                break;
            default:
                result = types.get(0);
                break;
        }
        return result;
    }

}