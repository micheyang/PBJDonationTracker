
package model;

public class Item {
    private String time;
    private String location;
    private String shortDescription;
    private String fullDescription;
    private double value;
    private String category;

    public Item() {
        this("Time", "Location", "Short Description", "fullDescription", 0, "category");
    }

    public Item(String time, String location, String shortDescription, String fullDescription, double value, String category) {
        this.time = time;
        this.location = location;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.value = value;
        this.category = category;
    }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getShortDescription() { return shortDescription; }
    public void setShortDescription(String shortDescription) {this.shortDescription = shortDescription; }

    public String getFullDescription() { return fullDescription; }
    public void setFullDescription(String fullDescription) { this.fullDescription = fullDescription; }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    //add tostring and equals

}
