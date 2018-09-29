package model;

import java.util.HashMap;
import java.util.IllegalFormatWidthException;

public class UserDatabase {

    //stores username as key with associated User object as value
    private HashMap<String, User> users;

    //constructor to initialize database with empty hashmap
    public UserDatabase() {
        users = new HashMap<>();
    }

    /**
     * Adds a new user to the database.
     *
     * @param user User to add to user database
     * @return true if user was added, false if user was not added
     * @throws IllegalArgumentException if user is null
     */
    public boolean addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Cannot add a null User.");
        }
        if (users.containsKey(user.getUsername())) {
            return false;
        } else {
            users.put(user.getUsername(), user);
            return true;
        }
    }

    /**
     * Removes an existing user from database.
     *
     * @param user User to remove from user database
     * @return the removed User value (or null)
     * @throws IllegalArgumentException if user is null or user doesn't exist
     */
    public User removeUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Cannot use null argument.");
        } else if (!users.containsKey(user.getUsername())) {
            throw new IllegalArgumentException("Cannot remove nonexistant user.");
        }
        return users.remove(user.getUsername());
    }

    /**
     * Checks if a user w/ inputted username exists in our database.
     *
     * @param username the username to search the database for
     * @return true if user exists in database, false if no user exists
     */
    public boolean containsUser(String username) {
        return users.containsKey(username);
    }

    /**
     * Checks if the password input matches the password of the User input
     * @param password the password that may/may not match
     * @param user the user with password to compare input with
     * @return true if values of passwords match, false if no
     */
    public boolean matchPassword(String password, User user) {
        if (user == null || password == null) {
            throw new IllegalArgumentException("Cannot have null arguments.");
        }
        if (!users.containsKey(user.getUsername())) {
            throw new IllegalArgumentException("User does not exist.");
        } else {
            User u = users.get(user.getUsername());
            return u.getPassword().equals(password);
        }
    }

    public boolean updateUser(User newUser) {

    }


}
