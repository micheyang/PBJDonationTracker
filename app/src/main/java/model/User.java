package model;

public class User {

    private String username;
    private String password;
    private String email;
    private boolean locked;

    /**
     * Constructor that initializes data for this User object.
     * Newly registered user accounts are 'unlocked' by default.
     *
     * @param username the username of this user's account
     * @param password the password of this user's account
     * @param email    the user's email to be used for contact
     */
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.locked = false;
    }

    /**
     * Getters/setters for this User's attributes
     */
    public String getUsername() { return username; }
    public void setUsername(String _username) { username = _username; }

    public String getPassword() { return password; }
    public void setPassword(String _password) { password = _password; }

    public String getEmail() { return email; }
    public void setEmail(String _email) { email = _email; }

    public boolean getLocked() { return locked; }
    public void setLock(boolean _locked) { locked = _locked; }



}