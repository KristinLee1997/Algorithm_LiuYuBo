package structure.quick.quicksort1;

import java.util.Arrays;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/1 9:30
 * @desc
 **/
public class Main {
    public static void main(String[] args) {
        int N = 10000;

        // 测试1 一般性测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("structure.quick.quicksort1.MergeSort2", arr1);
        SortTestHelper.testSort("structure.quick.quicksort1.QuickSort1", arr2);

        System.out.println();


        // 测试2 测试近乎有序的数组
        // 但是对于近乎有序的数组, 我们的快速排序算法退化成了O(n^2)级别的算法
        // 思考一下为什么对于近乎有序的数组, 快排退化成了O(n^2)的算法? :)
        int swapTimes = 10;
//        assertTest swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("structure.quick.quicksort1.MergeSort2", arr1);
        SortTestHelper.testSort("structure.quick.quicksort1.QuickSort1", arr2);

        return;
    }
}
