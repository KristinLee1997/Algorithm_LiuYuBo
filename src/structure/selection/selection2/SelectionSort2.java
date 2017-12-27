package structure.selection.selection2;

/**
 * @author LiHang
 * School: 哈尔滨理工大学
 * Saying: Never give up !!!
 * Date:   2017/11/28 20:26
 * Goal:
 **/
public class SelectionSort2 {
    public SelectionSort2() {
    }

    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 5, 9, 7, 3, 4, 8, 2, 6};
        SelectionSort2.sort(arr);
        SelectionSort2.printArray(arr);

        Student[] stu = new Student[5];
        stu[0] = new Student("aa", 12);
        stu[1] = new Student("ac", 40);
        stu[2] = new Student("bb", 22);
        stu[3] = new Student("dd", 22);
        stu[4] = new Student("bc", 50);
        SelectionSort2.sort(stu);
        SelectionSort2.printArray(stu);
    }
}
