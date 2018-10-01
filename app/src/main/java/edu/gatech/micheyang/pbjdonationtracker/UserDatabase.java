package edu.gatech.micheyang.pbjdonationtracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is used strictly to manage and update the data inputted by users in each session.
 * Each static list is updated with inputted values prompted from EditText/Spinner objects.
 * Stored data may be used to check validity when a user tries to login/register.
 */
public class UserDatabase {

    //attribute lists to be updated with respective user information
    static List<String> usernames = new ArrayList<>();
    static List<String> passwords = new ArrayList<>();
    static List<String> emails = new ArrayList<>();
    static List<String> types = new ArrayList<>();

}
