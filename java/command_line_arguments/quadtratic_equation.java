import stdlib.StdOut;

public class Quadratic {
    public static void main(String[] args) {
        // Parse your inputs as doubles - a and c can't be zero or we will get a divide by zero error
        double a = Double.parseDouble(args[0]);
        if (a == 0) {
            StdOut.println("Value of a must not be 0");
        }
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        if (c ==0) {
            StdOut.println("Value of a must not be 0");
        }
        // Calculate the discriminant as a double
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            StdOut.println("Value of discriminant must not be negative");
        }
        // Calculate the two roots of the discriminant
        double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        // Print the first root without a new line but with a space
        if (discriminant > 0) {
            StdOut.print(root1 + " ");
            // Print the second root with a new line
            StdOut.println(root2);
        }
    }
}
