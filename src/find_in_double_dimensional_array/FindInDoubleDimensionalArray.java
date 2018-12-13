package find_in_double_dimensional_array;

// 二维数组的查找
// 题目：在一个二维数组中，每一行元素都按照从左到右递增的顺序排序，
// 每一列元素都按照从上到下递增的顺序排序。
// 实现一个查找功能的函数，函数的输入为二维数组和一个整数，判断数组中是否含有该整数。
//
// 思路：首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束；
// 如果该数字大于要查找的数字，则剔除该数字所在的列；
// 如果该数字小于要查找的数字，则剔除该数字所在的行。
// 也就是说如果要查找的数字不在数组的右上角，则每一次都在数组的查找范围内删除一行或一列，
// 这样每一步都可以缩小查找的范围，直到找到要查找的数字，或者查找范围为空
public class FindInDoubleDimensionalArray {
    public static boolean find(int[][] array, int number) {
        int row = array.length;
        int col = array[0].length;
        int i = 0, j = col - 1;
        while (i < row && j >= 0) {
            if (array[i][j] == number) {
                return true;
            } else if (array[i][j] > number) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = {{1,2,8,9}, {2,4,9,12}, {4,7,10,13}, {6,8,11,15}};
        boolean res = find(array, 3);
        System.out.println(res);
    }
}
