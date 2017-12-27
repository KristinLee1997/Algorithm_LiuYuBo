package structure.heap.shift_down;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/3 13:02
 * @desc 删除大顶堆的堆顶元素后, 调整大顶堆数据元素, 仍保持为一个大顶堆
 **/
public class MaxHeap<Item extends Comparable> {
    private Item[] data;
    private int size;
    private int capacity;

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    public MaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        this.size = 0;
        this.capacity = capacity;
    }

    // 返回堆中的元素个数
    public int size() {
        return size;
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 像最大堆中插入一个新的元素 item
    public void insert(Item item) {
        assert size + 1 <= capacity;
        data[size + 1] = item;
        size++;
        shiftUp(size);
    }

    //获取大顶堆中最大的元素--第一个元素
    public Item getMax() {
        assert size > 0;
        return data[1];
    }


    //取出最大堆中的堆顶元素
    public Item extractMax() {
        assert size > 0;
        Item ret = data[1];
        swap(1, size);
        size--;
        shiftDown(1);
        return ret;
    }

    //* 最大堆核心辅助函数--插入元素后的调整堆操作
    private void shiftUp(int k) {
        while (k > 1 && data[k].compareTo(data[k / 2]) > 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    //* 最大堆核心辅助函数--删除元素后的调整堆操作
    private void shiftDown(int father) {
        while (2 * father <= size) {
            int child = 2 * father;//本轮循环中,data[k]要与data[j]交换的位置
            if (child + 1 <= size && data[child].compareTo(data[child + 1]) < 0) {
                child += 1; //把左右孩子中最大值得角标赋给j,然后与k进行交换
            }
            if (data[father].compareTo(data[child]) > 0) {
                break;  //如果此时data[k]大于data[j],那么不用交换了,退出循环即可
            }
            swap(father, child);
            father = child;
        }
    }

    //删除元素后调整大顶堆---金龙版(易于理解)
    private void shiftDown2(int father) {
        while (true) {
            int lchild = father * 2;//左孩子下角标
            int rchild = father * 2 + 1;//右孩子下角标
            int newFather = father;//新父节点下角标

            if (lchild > size) { //没有子节点
                return;
            } else if (rchild > size) { //只有左孩子
                newFather = max(father, lchild); //找到下标为father,lchild的最大元素值
            } else {        //有左、右孩子
                newFather = max(father, lchild, rchild);//找到下标为father,lchild,rchild的最大元素值
            }
            if (newFather == father) { //这时说明父节点元素大于所有子节点元素,已有序,不需继续调整
                return;
            } else {
                swap(father, newFather);
                father = newFather;
            }
        }
    }

    //返回元素角标为a,b 中最大值的角标
    private int max(int a, int b) {
        if (data[a].compareTo(data[b]) > 0) {
            return a;
        } else {
            return b;
        }
    }

    //返回元素角标为a,b,c 中最大值的角标
    private int max(int a, int b, int c) {
        int biggest = max(a, b);
        biggest = max(biggest, c);
        return biggest;
    }

    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j) {
        Item temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        int N = 100; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for (int i = 0; i < N; i++) {
            maxHeap.insert(new Integer((int) (Math.random() * M)));
        }

        Integer[] arr = new Integer[N];
        // 将maxheap中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for (int i = 0; i < N; i++) {
            arr[i] = maxHeap.extractMax();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从大到小排列的
        for (int i = 1; i < N; i++) {
            assert arr[i - 1] >= arr[i];
        }
    }
}
