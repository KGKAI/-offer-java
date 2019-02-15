package max_product_after_cutting;

public class MaxProductAfterCutting {
    public static int maxProductAfterCutting_solution1(int length) {
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;

        int[] products = new int[length + 1];
        // 不是乘积，因为绳子本身的长度比乘积大，只是段的长度？
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max;
        for (int i = 4; i <= length; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }

                products[i] = max;
            }
        }

        max = products[length];
        return max;
    }

    public static int maxProductAfterCutting_solution2(int length) {
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;

        int timesOf3 = length / 3;
        if (length - timesOf3 * 3 == 1) {
            timesOf3 -= 1;
        }
        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int)Math.pow(3, timesOf3) * (int)Math.pow(2, timesOf2);
    }

    public static void main(String[] args) {
//        System.out.println("4:" + maxProductAfterCutting_solution1(4));
//        System.out.println("5:" + maxProductAfterCutting_solution1(5));
//        System.out.println("6:" + maxProductAfterCutting_solution1(6));
//        System.out.println("7:" + maxProductAfterCutting_solution1(7));
//        System.out.println("8:" + maxProductAfterCutting_solution1(8));
//        System.out.println("9:" + maxProductAfterCutting_solution1(9));
//        System.out.println("10:" + maxProductAfterCutting_solution1(10));

        System.out.println("4:" + maxProductAfterCutting_solution2(4));
        System.out.println("5:" + maxProductAfterCutting_solution2(5));
        System.out.println("6:" + maxProductAfterCutting_solution2(6));
        System.out.println("7:" + maxProductAfterCutting_solution2(7));
        System.out.println("8:" + maxProductAfterCutting_solution2(8));
        System.out.println("9:" + maxProductAfterCutting_solution2(9));
        System.out.println("10:" + maxProductAfterCutting_solution2(10));
    }
}
