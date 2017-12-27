package structure.bubble;


import structure.insertion.insertion2.SortTestHelper;

/**
 * @author LiHang
 * School: 哈尔滨理工大学
 * Saying: Never give up !!!
 * Date:   2017/11/29 14:08
 * Goal:
 **/
public class InsertionSort2 {
    //算法不允许产生任何实例
    public InsertionSort2() {
    }

    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //第一种方法
//            for (int j = i; j > 0; j--) {
//                if (arr[j].compareTo(arr[j - 1]) < 0) {
//                    swap(arr,j,j-1);
//                } else {
//                    break;
//                }
//            }

            //第二种方法
//            for(int j=i;j>0&&arr[j].compareTo(arr[j-1])<0;j--){
//                swap(arr,j,j-1);
//            }
        }

        //第三种方法
        for (int i = 1; i < arr.length; i++) {
            Comparable temp = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1].compareTo(temp) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }


    public static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int n = 2000;
        Integer[] arr = structure.insertion.insertion1.SortTestHelper.generateRandomArray(n, 0, 100000);
        structure.insertion.insertion1.SortTestHelper.testSort("structure.insertion.insertion1.InsertionSort1", arr);
        SortTestHelper.printArray(arr);
        return;
    }
}
