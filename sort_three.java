import stdlib.StdOut;

public class ThreeSort {
    public static void main(String[] args) {
        // Get inputs and make them integers
        int x =Integer.parseInt(args[0]);
        int y=Integer.parseInt(args[1]);
        int z=Integer.parseInt(args[2]);
        // Order them by computing min within min using Math.min and same for max
        int alpha = Math.min(x, Math.min(y,z));
        int omega = Math.max(x, Math.max(y,z));
        // Find the middle by summing all three and subtracting the largest and the smallest
        int middle = x + y + z - alpha - omega;
        // Print the answer
        StdOut.println(alpha + " " + middle + " " + omega);
        }
    }
