package structure.bubble;

import java.lang.reflect.Method;

/**
 * @author LiHang
 * School: 哈尔滨理工大学
 * Saying: Never give up !!!
 * Date:   2017/11/29 13:08
 * Goal:
 **/
public class SortTestHelper {
    //SortTestHelper不允许产生实例
    public SortTestHelper() {
    }

    //生成有n个元素的随机数组,每个元素的随机范围为[rangeL,rangeR]
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Integer((int) (Math.random() * (rangeR - rangeL + 1) + rangeL));
        }
        return arr;
    }

    //生成一个近乎有序的数组
    //首先生成一个含有[0...n-1]的完全有序的数组,之后随机交换swapTimes对数据
    //swapTimes定义了数组的无序程度
    //swapTimes==0时,数组完全有序
    //swapTimes越大,数组越趋于无序
    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < swapTimes; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            int t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }
        return arr;
    }

    //打印数组arr的所有内容
    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //判断数组arr是否有序
    public static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    //测试sortClassName所对应的排序算法排序arr数组所得到的结果正确性和算法时间
    public static void testSort(String sortClassName, Comparable[] arr) {
        try {
            //通过sortClassName获得排序函数的class对象
            Class sortClass = Class.forName(sortClassName);

            //通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});

            //排序参数只有一个,就是可比较数组arr
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();

            assert isSorted(arr);

            System.out.println(sortClass.getSimpleName() + ":" + (endTime - startTime) + "ms");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
