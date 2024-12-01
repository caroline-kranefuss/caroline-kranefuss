import dsa.Quick;
import stdlib.StdOut;

import java.util.Comparator;

public class Location implements Comparable<Location> {
    private String name; // location name
    private double lat;  // latitude
    private double lon;  // longitude

    // Constructs a new location given its name, latitude, and longitude.
    public Location(String name, double lat, double lon) {
        // use this.variable = variable format since variable is called in the constructor
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    // Returns the great-circle distance between this location and other.
    public double distanceTo(Location other) {
        // other's data type is Location
        // mathematically calculate GCD
        // Get all the input variables as doubles and convert to doubles
        // Only work with input inside main but args is limited to main
        // working with this and other
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
        double a = sinX1 * sinX2 + cosX1 * cosX2 * cosY;
        // Find arccos using acos(a)
        double ans = 6359.83 * Math.acos(a);
        // return the final answer
        return ans;
    }

    // Returns true if this location is the same as other, and false otherwise.
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        Location a = this, b = (Location) other;
        return a.lat == b.lat && a.lon == b.lon;
    }

    // Returns a string representation of this location.
    public String toString() {
        // concatenate String and doubles into a string
        return this.name + " (" + this.lat + ", " + this.lon + ")";
    }

    // Returns a comparison of this location with other based on their respective distances to the origin, Parthenon
    // (Greece) @ 37.971525, 23.726726.
    public int compareTo(Location other) {
        // what is the origin - Parthenon (Greece) @ 37.971525, 23.726726
        // use a constructor to create a Location object
        Location origin = new Location("Parthenon (Greece)", 37.971525, 23.726726);
        // this to origin (double)
        double this_to_origin = origin.distanceTo(this);
        // other to origin
        double other_to_origin = origin.distanceTo(other);
        // compare those two distances
        return Double.compare(this_to_origin, other_to_origin);
    }

    // Returns a comparator for comparing two locations by their names.
    // nameOrder() is a method
    public static Comparator<Location> nameOrder() {
        // return an object of type NameOrder
        // what type is it?
        // comparable object can be compared and return a value
        // comparator gives instructions on how to compare things
        // want a data type that implements comparator
        // use an implicit constructor (method) to create and return an object
        // always has same name as data type itself
        return new NameOrder();
    }

    // Name comparator.
    private static class NameOrder implements Comparator<Location> {
        // Returns a comparison of locations v and w by their names.
        public int compare(Location v, Location w) {
            // Return a negative, zero, or positive integer
            // based on whether v.name is less than, equal to, or greater than w.name
            // Strings are comparable via String.compareTo(<string>);
            // compare is inside a comparator
            // compareTo() is inside a comparable
            // compareTo() returns 1, 0, or -1 depending on where it fits
            return v.name.compareTo(w.name);
        }
    }

    // Unit tests the data type. [DO NOT EDIT]
    public static void main(String[] args) {
        Location[] wonders = new Location[7];
        wonders[0] = new Location("The Great Wall of China (China)", 40.6769, 117.2319);
        wonders[1] = new Location("Petra (Jordan)", 30.3286, 35.4419);
        wonders[2] = new Location("The Colosseum (Italy)", 41.8902, 12.4923);
        wonders[3] = new Location("Chichen Itza (Mexico)", 20.6829, -88.5686);
        wonders[4] = new Location("Machu Picchu (Peru)", -13.1633, -72.5456);
        wonders[5] = new Location("Taj Mahal (India)", 27.1750, 78.0419);
        wonders[6] = new Location("Christ the Redeemer (Brazil)", 22.9519, -43.2106);
        Quick.sort(wonders);
        StdOut.println("Seven wonders in the order of their distance to Parthenon (Greece):");
        for (Location wonder : wonders) {
            StdOut.println("  " + wonder);
        }
        Quick.sort(wonders, Location.nameOrder());
        StdOut.println("Seven wonders in alphabetical order:");
        for (Location wonder : wonders) {
            StdOut.println("  " + wonder);
        }
    }
}
