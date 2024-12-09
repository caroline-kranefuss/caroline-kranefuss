// Using parseDouble to calculate the great circle distance between two points

import stdlib.StdOut;

public class GreatCircle {
    public static void main(String[] args) {
        // Get all the input variables as doubles and convert to doubles
        double x1 = Double.parseDouble(args[0]);
        double y1 = Double.parseDouble(args[1]);
        double x2 = Double.parseDouble(args[2]);
        double y2 = Double.parseDouble(args[3]);
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
        // Find arccos using acos(a)
        double a = sinX1 * sinX2 + cosX1 * cosX2 * cosY;
        double distance = 6359.83 * Math.acos(a);
        // Print the final answer
        StdOut.println(distance);
    }
}
