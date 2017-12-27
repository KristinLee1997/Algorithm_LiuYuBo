package structure.heap.heap_print;


/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/3 16:33
 * @desc 打印堆
 **/
public class HeapPrint<T extends Comparable> {
    private T[] data;
    private int size;
    private int capacity;

    public HeapPrint(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.data = (T[]) new Comparable[capacity + 1];
    }

    public HeapPrint(T[] arr) {//heapify,数组建堆
        capacity = arr.length;
        data = (T[]) new Comparable[capacity + 1];
        System.arraycopy(arr, 0, data, 1, arr.length);
        size = arr.length;
        for (int i = size / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    public int size() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T seekMax() {
        return data[1];
    }

    public void swap(int i, int j) {
        if (i != j) {
            T temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
    }

    public void insert(T item) {
        size++;
        data[size] = item;
        shiftUp(size);
    }

    public T popMax() {
        swap(1, size--);
        shiftDown(1);
        return data[size + 1];
    }

    public void shiftUp(int child) {
        while (child > 1 && data[child].compareTo(data[child / 2]) > 0) {
            swap(child, child / 2);
            child /= 2;
        }
    }

    /**
     * @param a data数组中某个元素的下角标
     * @param b data数组中某个元素的下角标
     * @return 哪个元素大就返回哪个的下角标
     */
    private int max(int a, int b) {
        if (data[a].compareTo(data[b]) < 0) {//如果data[b]大
            return b;//返回b
        } else {//如果data[a]大
            return a;//返回a
        }
    }

    /**
     * @param a data数组中某个元素的下角标
     * @param b data数组中某个元素的下角标
     * @param c data数组中某个元素的下角标
     * @return 哪个元素大就返回哪个的下角标
     */
    private int max(int a, int b, int c) {
        int biggest = max(a, b);
        biggest = max(biggest, c);
        return biggest;
    }

    public void shiftDown(int father) {
        while (true) {
            int lchild = father * 2;
            int rchild = father * 2 + 1;
            int newFather = father;//这里赋不赋值无所谓，如果把下面这个return改成break,那就必须赋值了

            if (lchild > size) {//如果没有左、右孩子
                return;
            } else if (rchild > size) {//如果没有右孩子
                newFather = max(father, lchild);
            } else {//如果有左、右孩子
                newFather = max(father, lchild, rchild);
            }

            if (newFather == father) {//如果原父结点就是三者最大，则不用继续整理堆了
                return;
            } else {//父节点不是最大，则把大的孩子交换上来，然后继续往下堆调整，直到满足大根堆为止
                swap(newFather, father);
                father = newFather;//相当于继续shiftDown(newFather)。假如newFather原来是father的左孩子，那就相当于shiftDown(2*father)
            }
        }
    }

    public static <T extends Comparable<? super T>> void sort(T[] arr) {
        int len = arr.length;
        HeapPrint<T> maxHeap = new HeapPrint<>(arr);
        maxHeap.printHeap();
        for (int i = len - 1; i >= 0; i--) {
            arr[i] = maxHeap.popMax();
        }
    }

    public static void printArr(Object[] arr) {
        for (Object o : arr) {
            System.out.print(o);
            System.out.print("\t");
        }
        System.out.println();
    }

    public void printSpace(int n) {//打印n个空格(在这里用‘\t’来代替)
        for (int i = 0; i < n; i++) {
            System.out.printf("%3s", "");
        }
    }


    //按层打印堆
    public void printHeap() {
        int lines = (int) (Math.log(size) / Math.log(2)) + 1;//lines是堆的总层数
        int spaceNum = (int) (Math.pow(2, lines) - 1);//第一层堆空格数
        //line:每层的层数
        for (int i = 1, line = 1; i <= size; line++, spaceNum /= 2) {
            for (int j = (int) Math.pow(2, line - 1); j <= Math.min(size, (int) Math.pow(2, line) - 1); j++) {
                printSpace(spaceNum);
                System.out.printf("%3s", data[j]);//打印数据
                System.out.printf("%3s", "");    //要是把%3s都换成了\t就特别分散,不好看
                printSpace(spaceNum);
                i++;//每打印一个元素就 + 1
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 5, 9, 7, 3, 4, 8, 6, 2, 11, 15, 19, 17, 18, 16, 13, 14, 10, 20};
        sort(arr);
    }
}
