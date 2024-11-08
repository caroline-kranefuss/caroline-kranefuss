import stdlib.StdOut;

import java.util.Objects;

public class Location {
    private String name; // location name
    private double lat;  // latitude
    private double lon;  // longitude

    // Constructs a new location given its name, latitude, and longitude.
    public Location(String name, double lat, double lon) {
        // set as name, lat, and lon to start
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    // Returns the great-circle distance between this location and other.
    public double distanceTo(Location other) {
        // Use this and other to pass in lat and lon
        double x1 = this.lat;
        double y1 = this.lon;
        double x2 = other.lat;
        double y2 = other.lon;
        // Convert degrees to radians because sin and cos take in radians!
        double x1Rad = Math.toRadians(x1);
        double y1Rad = Math.toRadians(y1);
        double x2Rad = Math.toRadians(x2);
        double y2Rad = Math.toRadians(y2);
        // Create small variables for sin and cos of the variables above
        double sinX1 = Math.sin(x1Rad);
        double sinX2 = Math.sin(x2Rad);
        double cosX1 = Math.cos(x1Rad);
        double cosX2 = Math.cos(x2Rad);
        // Do math with the small variables
        double deltaY = y1Rad - y2Rad;
        double cosY = Math.cos(deltaY);
        // Find arc cos using acos(a)
        double a = sinX1 * sinX2 + cosX1 * cosX2 * cosY;
        double distance = 6359.83 * Math.acos(a);
        return distance;
    }

    // Returns true if this location is the same as other, and false otherwise.
    public boolean equals(Object other) {
        // if other id null, return false
        if (other == null) {
            return false;
        }
        // if other and this are the same return true
        if (other == this) {
            return true;
        }
        // if the class of other does not equal the class of this, return false
        if (other.getClass() != this.getClass()) {
            return false;
        }
        // set location a this equal to location b of other
        Location a = this, b = (Location) other;
        // return name of a and b if they're equal (use equals method) and == for lat and lon since they are longs
        return Objects.equals(a.name, b.name) && a.lat == b.lat && a.lon ==b.lon;
    }

    // Returns a string representation of this location.
    public String toString() {
        return name + " (" + lat + ", " + lon + ")";
    }

    // Unit tests the data type. [DO NOT EDIT]
    // Passing in the values here
    public static void main(String[] args) {
        Location x = new Location("Paris", 48.51, -2.17);
        Location y = new Location("Boston", 42.36, -71.05);
        // printing in the right format
        StdOut.println("x               = " + x);
        StdOut.println("y               = " + y);
        StdOut.println("x.distanceTo(y) = " + x.distanceTo(y));
        StdOut.println("x.equals(y)     = " + x.equals(y));
    }
}
