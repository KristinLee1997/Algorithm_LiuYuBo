package structure.heap.max_heap;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/3 12:09
 * @desc 构造容量为capacity的大顶堆
 **/
public class MaxHeap<T> {
    //每一个结点的值,存放在数组中,角标从1开始
    private T[] data;
    //结点总数
    private int count;

    //构造一个可以容纳capacity个结点的堆
    public MaxHeap(int capacity) {
        data = (T[]) new Object[capacity + 1];
        count = 0;
    }

    //返回堆中元素的个数
    public int size() {
        return count;
    }

    //返回boolean值,判断堆是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxheap = new MaxHeap<Integer>(100);
        System.out.println(maxheap.size());
    }
}
