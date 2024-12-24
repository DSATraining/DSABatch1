
// InsertionSort.java
// Insertion Sort implementation in Java

public class InsertionSort {

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int incorrectly_positioned_value = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than incorrectly_positioned_value
            while (j >= 0 && arr[j] > incorrectly_positioned_value) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = incorrectly_positioned_value;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};
        insertionSort(arr);
        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
    }
}
