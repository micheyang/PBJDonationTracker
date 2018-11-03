package edu.gatech.micheyang.pbjdonationtracker.db_model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Location {

    private int id;
    private int key;
    private String name;
    private String latitude;
    private String longitude;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String type = types.get(0);
    private String phoneNumber;
    private String website;

    private List<Item> inventory = new ArrayList<>();
    private List<User> employeeList = new ArrayList<>();

    public static List<String> types = Arrays.asList("DROPOFF", "STORE", "WAREHOUSE");

    public int getId() { return id; }
    public int getKey() { return key; }
    public String getName() { return name; }
    public String getLatitude() { return latitude; }
    public String getLongitude() { return longitude; }
    public String getStreetAddress() { return streetAddress; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZipCode() { return zipCode; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getWebsite() { return website; }
    public List<Item> getInventory() { return inventory; }
    public List<User> getEmployeeList() { return employeeList; }
    public String getType() { return type; }

    public void setId(int id) { this.id = id; }
    public void setKey(int key) { this.key = key; }
    public void setName(String name) { this.name = name; }
    public void setLatitude(String latitude) { this.latitude = latitude; }
    public void setLongitude(String longitude) { this.longitude = longitude; }
    public void setStreetAddress(String streetAddress) { this.streetAddress = streetAddress; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setWebsite(String website) { this.website = website; }
    public void setInventory(List<Item> inventory) { this.inventory = inventory; }
    public void setEmployeeList(List<User> employeeList) { this.employeeList = employeeList; }
    public void setType(String type) {
        if (!(types.contains(type))) {
            this.type = types.get(0);
        } else {
            this.type = type;
        }
    }

    public String toString() {

        return "Location " + key + " is: " + name;
    }

}

//
//    public Location(int key, String name, String latitude, String longitude, String streetAddress,
//                    String city, String state, String zipCode, String type, String phoneNumber, String website) {
//        this.key = key;
//        this.name = name;
//        this.latitude = latitude;
//        this.longitude = longitude;
//        this.streetAddress = streetAddress;
//        this.city = city;
//        this.state = state;
//        this.zipCode = zipCode;
//        this.type = type;
//        this.phoneNumber = phoneNumber;
//        this.website = website;
//    }
