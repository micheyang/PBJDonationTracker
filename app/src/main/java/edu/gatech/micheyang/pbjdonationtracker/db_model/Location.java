package edu.gatech.micheyang.pbjdonationtracker.db_model;

public class Location {

    private int key;
    private String name;
    private String latitude;
    private String longitude;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String type;
    private String phoneNumber;
    private String website;

    public Location(int key, String name, String latitude, String longitude, String streetAddress,
                    String city, String state, String zipCode, String type, String phoneNumber, String website) {
        this.key = key;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.type = type;
        this.phoneNumber = phoneNumber;
        this.website = website;
    }

    public String toString() {
        return "Location " + key + " is: " + name;
    }

    public int getKey() { return key; }
    public String getName() { return name; }
    public String getLatitude() { return latitude; }
    public String getLongitude() { return longitude; }
    public String getStreetAddress() { return streetAddress; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZipCode() { return zipCode; }
    public String getType() { return type; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getWebsite() { return website; }

    public void setKey(int key) { this.key = key; }
    public void setName(String name) { this.name = name; }
    public void setLatitude(String latitude) { this.latitude = latitude; }
    public void setLongitude(String longitude) { this.longitude = longitude; }
    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
    public void setType(String type) { this.type = type; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setWebsite(String website) { this.website = website; }

}
