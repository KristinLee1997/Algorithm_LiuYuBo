package structure.heap.shift_up;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/3 12:20
 * @desc 在数组末尾,插入一个元素后,调整大顶堆中元素,保持数据结构仍为大顶堆
 **/
//在堆有关的操作中,需要比较堆中元素的大小,所以Item应该 extends Comparable
public class MaxHeap<Item extends Comparable> {
    //使用protected可能是为了以后有子类继承MaxHeap增加新功能时可以使用父类的属性吧...(PrintableMaxHeap继承时就使用了)
    protected Item[] data;
    protected int count;
    protected int capacity;

    //构造一个可以容纳capacity个元素的堆
    public MaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    //返回堆中元素的个数
    public int size() {
        return count;
    }

    //返回堆是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    //向大顶堆中插入一个新元素 item
    public void insert(Item item) {
        assert count + 1 <= capacity;
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    //核心函数--调整新元素在堆中的位置
    private void shiftUp(int k) {
        while (k > 1 && data[k].compareTo(data[k / 2]) > 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    private void swap(int i, int j) {
        Item temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxheap = new MaxHeap<Integer>(100);
        int n = 50;//堆中元素个数
        int m = 100; //堆中元素范围[0-m)
        for (int i = 0; i < n; i++) {
            maxheap.insert(new Integer((int) (Math.random() * m)));
        }
        System.out.println(maxheap.size());

    }
}
