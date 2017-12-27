package structure.insertion.insertion1;

/**
 * @author LiHang
 * School: 哈尔滨理工大学
 * Saying: Never give up !!!
 * Date:   2017/11/29 13:31
 * Goal:
 **/
public class InsertionSort1 {
    //算法不允许产生任何实例
    public InsertionSort1() {
    }

    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
//            for (int j = i; j > 0; j--) {
//                if (arr[j].compareTo(arr[j - 1]) < 0) {
//                    swap(arr,j,j-1);
//                } else {
//                    break;
//                }
//            }

            for(int j=i;j>0&&arr[j].compareTo(arr[j-1])<0;j--){
                swap(arr,j,j-1);
            }
        }
    }


    public static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int n = 2000;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, 100000);
        SortTestHelper.testSort("structure.insertion.insertion1.InsertionSort1", arr);
        SortTestHelper.printArray(arr);
        return;
    }
}
