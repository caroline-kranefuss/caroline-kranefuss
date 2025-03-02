import stdlib.StdOut;

public class ThreeSort {
    // Entry Point.
    public static void main(String[] args) {
        // get inputs as strings
        String xstr = args[0];
        String ystr = args[1];
        String zstr = args[2];
        // convert the strings to ints
        int x = Integer.parseInt(xstr);
        int y = Integer.parseInt(ystr);
        int z = Integer.parseInt(zstr);
        // save the min of x and y and the max of x and y
        int xy_min = Math.min(x,y);
        int xy_max = Math.max(x,y); 
        // the smaller of xy_min and z is the very smallest
        int smallest = Math.min(xy_min, z);
        // the smaller of xy_max and the larger of xy_min and z is the middle
        int middle = Math.min(xy_max, Math.max(xy_min, z));
        // find the larger of xy_max and z for the largest
        int largest = Math.max(xy_max, z);
        StdOut.print(smallest);
        StdOut.print(" ");
        StdOut.print(middle);
        StdOut.print(" ");
        StdOut.println(largest);
    }
}


//Another option given in class:
        // Order them by computing min within min using Math.min and same for max
        //int alpha = Math.min(x, Math.min(y,z));
        //int omega = Math.max(x, Math.max(y,z));
        // Find the middle by summing all three and subtracting the largest and the smallest
        //int middle = x + y + z - alpha - omega;
