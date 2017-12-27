package structure.shell;

import structure.bubble.SortTestHelper;

import java.util.Arrays;

/**
 * @author LiHang
 * School: 哈尔滨理工大学
 * Saying: Never give up !!!
 * Date:   2017/11/29 14:37
 * Goal:
 **/
public class Main {
    public static void main(String[] args) {
        int N = 20000;

        //test1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("structure.shell.SelectionSort4", arr1);
        SortTestHelper.testSort("structure.shell.InsertionSort2", arr1);
        SortTestHelper.testSort("structure.shell.BubbleSort2", arr1);
        SortTestHelper.testSort("structure.shell.ShellSort", arr1);

        System.out.println();

        //test2 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("structure.shell.SelectionSort4", arr1);
        SortTestHelper.testSort("structure.shell.InsertionSort2", arr1);
        SortTestHelper.testSort("structure.shell.BubbleSort2", arr1);
        SortTestHelper.testSort("structure.shell.ShellSort", arr1);

        System.out.println();

        //test3 测试完全有序的数组
        //对于完全有序的数组,冒泡排序也将成为O(n)级别的算法
        swapTimes = 0;
        N = 10000000;    // 由于插入排序法和冒泡排序法在完全有序的情况下都将成为O(n)算法
        // 所以我们的测试数据规模变大，为1000,0000
        System.out.println("Test for ordered array, size = " + N);

        SortTestHelper.testSort("structure.shell.InsertionSort2", arr1);
        SortTestHelper.testSort("structure.shell.BubbleSort2", arr1);
        SortTestHelper.testSort("structure.shell.ShellSort", arr1);

        return;
    }
}
