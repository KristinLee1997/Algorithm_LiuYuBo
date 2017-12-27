package structure.insertion.insertion2;

import java.util.Arrays;

/**
 * @author LiHang
 * School: 哈尔滨理工大学
 * Saying: Never give up !!!
 * Date:   2017/11/29 14:16
 * Goal:
 **/
public class Main {
    public static void main(String[] args) {
        int N = 20000;
        //test1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("structure.insertion.insertion2.InsertionSort2", arr1);
        SortTestHelper.testSort("structure.insertion.insertion2.SelectionSort4", arr2);

        System.out.println();

        //test2 有序性更强的测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 3);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("structure.insertion.insertion2.InsertionSort2", arr1);
        SortTestHelper.testSort("structure.insertion.insertion2.SelectionSort4", arr2);

        System.out.println();

        //test3 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("structure.insertion.insertion2.InsertionSort2", arr1);
        SortTestHelper.testSort("structure.insertion.insertion2.SelectionSort4", arr2);

    }
}
