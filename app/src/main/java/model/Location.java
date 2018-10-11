package model;

public class Location {

    private String name;
    private String fruit;
    private int id;
    private String email;

    public Location(String n, String f, int i, String e) {
        name = n;
        fruit = f;
        id = i;
        email = e;
    }

    public String toString() {
        return name + " " + id;
    }

    public String getName() { return name; }
    public String getFruit() { return fruit; }
    public String getEmail() { return email; }
    public int getId() { return id; }

}
