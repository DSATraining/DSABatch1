
// SelectionSort.java
// Selection Sort implementation in Java

public class SelectionSort {

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int index_of_minimum_value = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[index_of_minimum_value]) {
                    index_of_minimum_value = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[index_of_minimum_value];
            arr[index_of_minimum_value] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort(arr);
        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
    }
}
