package edu.gatech.micheyang.pbjdonationtracker;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used strictly to manage and update the data inputted by users in each session.
 * Each static list is updated with inputted values prompted from EditText/Spinner objects.
 * Stored data may be used to check validity when a user tries to login/register.
 *
 * This is our temporary means of storing user inputs/information. This doesn't support
 * persistence for new app sessions, which is OK for M5 milestone. We'll modify this later.
 */
public class UserDatabase {

    //stores all valid inputted usernames
    public static List<String> usernames = new ArrayList<>();

    //stores all valid inputted passwords
    public static List<String> passwords = new ArrayList<>();

    //stores all valid inputted email adresses
    public static List<String> emails = new ArrayList<>();

    //stores all type values for user
    public static List<String> types = new ArrayList<>();

    //stores location employee id's 
    public static List<Integer> location = new ArrayList<>();

}
