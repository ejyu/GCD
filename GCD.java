import java.lang.Math;

/**
 * This program contains functions that help the user find the greatest
 * common divisor of two integers in question.
 * 
 * @author E.J. Yu
 */
public class GCD {


    /**
     * Calculates the GCD of two integers in question using the Euclidean
     * Algorithm.
     * 
     * @param a  The first integer in question.
     * @param b  The second integer in question.
     * @return   The greatest common divisor of the two integers passed into
     *           this method.
     */
    public static int Euclidean(int a, int b) {

        // Report program activity: ENTERING
        System.out.println(
            "Entering method: Euclidean()"
        );

        // Preserve arguments.
        int aPreserved = a;
        int bPreserved = b;

        // Reassign values such that a >= b is true.
        if(!(a >= b)) {
            a = b;
            b = aPreserved;
        }

        // Perform modulus arithmetic. 
        while(b != 0) {
            int r = (a % b);
            a = b;
            b = r;
        }

        // Report program activity: EXITING
        System.out.println(
            "Evaluation complete!\n" +
            "The GCD of " + aPreserved + " and " + bPreserved +
                " is: " + a + "\n" +
            "Exiting method: Euclidean()"
        );

        // Return the greatest common divisor of the args.
        return a;

    }

    /**
     * Calculates the GCD of two integers in question using the Modified
     * Euclidean Algorithm.
     * 
     * @param A  The first integer in question.
     * @param B  The second integer in question.
     * @return   An array with the information needed to calculate the
     *           GCD of two integers.
     */
    public static int[] ModifiedEuclidean(int A, int B) {

        // Report program activity: ENTERING
        System.out.println(
            "Entering method: ModifiedEuclidean()"
        );

        // Preserve arguments.
        int preservedA = A;
        int preservedB = B;

        // Reassign values such that A > B is true.
        if(!(A > B)) {
            A = B;
            B = preservedA;
        }

        // Initialize.
        int k = -2;
        int[] r = new int[99];
        int[] a = new int[99];
        int[] p = new int[99];
        int[] q = new int[99];
        r[k+2] = A;
        p[k+2] = 0;
        q[k+2] = 1;
        k++;
        r[k+2] = B;
        p[k+2] = 1;
        q[k+2] = 0;

        // While r of index k isn't zero, perform special steps.
        while(r[k+2] != 0) {
            k++;
            a[k+2] = (r[k] / r[k+1]);
            r[k+2] = (r[k] % r[k+1]);
            p[k+2] = ((a[k+2] * p[k+1]) + p[k]);
            q[k+2] = ((a[k+2] * q[k+1]) + q[k]);
        }

        // Let n = k.
        int n = k;

        // Prepare the output.
        int[] output = {n, r[n+1], p[n+1], q[n+1]};

        // Print the output that this method returns to the terminal.
        System.out.println(
            "Evaluation complete!\n" +
            "This function with arguments " + preservedA + " and " +
            preservedB + " returns... " + "\n" +
            "n = " + output[0] +  "\n" +
            "r of index (n - 1) = " + output[1] + "\n" +
            "p of index (n - 1) = " + output[2] + "\n" +
            "q of index (n - 1) = " + output[3] + "\n" +
            "...which are values in the array: " + "{" +
            output[0] + ", " + output[1] + ", " + output[2] + ", " +
            output[3] + "}"
        );

        // Print GCD to terminal.
        System.out.println(
            "The GCD of " + preservedA + " and " + preservedB +
                " is: " + output[1]
        );

        // Reassign values such that A < B is true.
        if(A > B) {
            int newA = B;
            int newB = A;
            A = newA;
            B = newB;
        }

        // Calculate (a^-1 (mod b)).
        int forModEquation = (((int)(Math.pow(-1, output[0]))) * output[2]);

        // Generate equation (a^-1 (mod b)) for coprime arguments.
        if(output[1] == 1) {
            System.out.println(
                "To get a^-1 (mod b), or " + A + "^-1 (mod " + B + ")" +
                " in this case, " + "solve this yourself: " + forModEquation +
                " (mod " + B + ")"
            );
        }
        else {
            System.out.println(
                "Since GCD does not equal 1, arguments aren't coprime."
                + "\n"
                + "Can't calculate a^-1 (mod b) for these arguments."
            );
        }
        

        // Report program activity: EXITING
        System.out.println(
            "Exiting method: ModifiedEuclidean()"
        );

        // Return the program's output.
        return output;

    }

    public static void main(String[] args) {

        // Euclidean Algorithm GCD
        Euclidean(4, 6);
        System.out.println();

        // Modified Euclidean Algorithm Output
        ModifiedEuclidean(4, 6);
        System.out.println();
        
        // Euclidean Algorithm GCD
        Euclidean(3, 6);
        System.out.println();

        // Modified Euclidean Algorithm Output
        ModifiedEuclidean(3, 6);
        System.out.println();
        
        // Euclidean Algorithm GCD
        Euclidean(8, 12);
        System.out.println();

        // Modified Euclidean Algorithm Output
        ModifiedEuclidean(8, 12);
        System.out.println();

        // Euclidean Algorithm GCD
        Euclidean(15, 10);
        System.out.println();

        // Modified Euclidean Algorithm Output
        ModifiedEuclidean(15, 10);
        System.out.println();

        // Euclidean Algorithm GCD
        Euclidean(293819, 81729);
        System.out.println();

        // Modified Euclidean Algorithm Output
        ModifiedEuclidean(293819, 81729);
        System.out.println();

    }

}