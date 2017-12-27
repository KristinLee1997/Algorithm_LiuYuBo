package structure.insertion.insertion1;

import java.util.Arrays;

/**
 * @author LiHang
 * School: 哈尔滨理工大学
 * Saying: Never give up !!!
 * Date:   2017/11/29 13:32
 * Goal:
 **/
public class Main {
    public static void main(String[] args) {
        int n = 20000;
        System.out.println("Test for random array, size = " + n + " , random range [0, " + n + "]");

        Integer[] arr1=SortTestHelper.generateRandomArray(n,0,n);
        Integer[] arr2= Arrays.copyOf(arr1,arr1.length);

        SortTestHelper.testSort("structure.insertion.insertion1.InsertionSort1",arr1);
        SortTestHelper.testSort("structure.insertion.insertion1.SelectionSort4",arr2);

        return;
    }
}
