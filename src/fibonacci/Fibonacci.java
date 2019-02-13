package fibonacci;

/**
 * 时间复杂度O(n)
 */
public class Fibonacci {
    public static long fibonacci(int n) {
        int[] result = {0, 1};
        if (n < 2) {
            return result[n];
        }

        long fibNMinusOne = 0;
        long finNMinusTwo = 1;
        long fibN = 0;
        for (int i = 2; i < n; i++) {
            fibN = fibNMinusOne + finNMinusTwo;

            fibNMinusOne = finNMinusTwo;
            finNMinusTwo = fibN;
        }

        return fibN;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(7));
    }
}
