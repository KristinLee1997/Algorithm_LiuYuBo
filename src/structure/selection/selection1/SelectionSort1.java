package structure.selection.selection1;

/**
 * Created with IntelliJ IDEA 2017.2.3
 * @author Li Hang
 * Saying: Never give up !!!
 * Date:   2017/11/28 20:02
 * Goal:    选择排序
 */
public class SelectionSort1 {
    public SelectionSort1() {
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            SelectionSort1.swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 9, 7, 3, 8, 2, 4, 6};
        SelectionSort1.sort(arr);
        SelectionSort1.printArray(arr);
    }
}
