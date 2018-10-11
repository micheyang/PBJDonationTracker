package model;

public class Location {

    private int key;
    private String name;
    private String latitude;
    private String longitude;
    private String streetAddress;
    private String city;
    private String state;
    private int zipcode;
    private String type;
    private String phoneNumber;
    private String website;

    public Location(int key, String name, String phoneNumber, String website) {
        this.key = key;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.website = website;
    }

    public String toString() {
        return "Location " + key + " is: " + name;
    }

    public int getKey() { return key; }
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getWebsite() { return website; }

}
