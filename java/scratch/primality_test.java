import stdlib.StdOut;

public class PrimalityTest {
    public static void main(String[] args) {
        int n=Integer.parseInt(args[0]);
        int flag = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                flag = 1;
            }
            else {
                flag = 0;
            }
        }
        if (flag == 1) {
            StdOut.println("false");
        }
        else {
            StdOut.println("true");
        }

    }
}

/*
n
set int i to 2
repeat as long as i <= n/i
    if i divides n, break
    increment i by 1
if i > n/i write true else false
 */
