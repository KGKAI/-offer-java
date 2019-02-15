package number_of_1;

public class NumberOf1 {
    public static int numberOf1_solution1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }

    public static int times(int n1, int n2) {
        int result = n1 ^ n2;
        int count = 0;
        while (result != 0) {
            count++;
            result = (result - 1) & result;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1_solution1(13));
        System.out.println(times(10, 13));
    }
}
