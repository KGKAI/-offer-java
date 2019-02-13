package quicksort;

public class QuickSort {
    // 标准算法实现
//    public static void quickSort(int[] arr, int start, int end) {
//        int i = start, j = end, x = arr[i];
//        while (i < j) {
//            while (i < j && arr[j] > x) {
//                j--;
//            }
//            if (i < j) {
//                arr[i++] = arr[j];
//            }
//            while(i < j && arr[i] < x) {
//                i++;
//            }
//            if (i < j) {
//                arr[j--] = arr[i];
//            }
//        }
//
//        arr[j] = x;
//        if (start < i) quickSort(arr, 0, i - 1);
//        if (end > i) quickSort(arr, i + 1, end);
//
//    }

    // 两头交换法实现
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int i = start, j = end, x = arr[(start + end) >> 1], tmp = 0;
        while(i <= j) {
            while(arr[i] < x) i++;
            while(arr[j] > x) j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        quickSort(arr, start, j);
        quickSort(arr, i, end);
    }

    public static void main(String[] args) {
        int[] arr = {72, 6, 57, 88, 60, 42, 83, 73, 48, 85};
        quickSort(arr, 0, 9);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
