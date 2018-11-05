package edu.gatech.micheyang.pbjdonationtracker.db_model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Location implements Serializable {

    private int id;
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

    private List<Item> inventory = new ArrayList<>();
    private List<User> employeeList = new ArrayList<>();

    public static List<String> types = Arrays.asList("DROPOFF", "STORE", "WAREHOUSE");

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
        if (types.contains(type)) {
            this.type = type;
        } else {
            this.type = types.get(0);
        }
        this.phoneNumber = phoneNumber;
        this.website = website;
    }

    public Location() { }

    public String toString() {
        return "Location " + key + " is: " + name;
    }

    public int getId() { return id; }
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
    public List<Item> getInventory() { return inventory; }
    public List<User> getEmployeeList() { return employeeList; }

    public void setId(int id) { this.id = id; }
    public void setKey(int key) { this.key = key; }
    public void setName(String name) { this.name = name; }
    public void setLatitude(String latitude) { this.latitude = latitude; }
    public void setLongitude(String longitude) { this.longitude = longitude; }
    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
    public void setType(String type) {
        if (types.contains(type)) {
            this.type = type;
        } else {
            this.type = types.get(0);
        }
    }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setWebsite(String website) { this.website = website; }
    public void setInventory(List<Item> inventory) { this.inventory = inventory; }
    public void setEmployeeList(List<User> list) { this.employeeList = list; }

    public String formatAddress() {
        return (this.streetAddress + " " + this.city + ", " + this.state + " " + this.zipCode);
    }

}
