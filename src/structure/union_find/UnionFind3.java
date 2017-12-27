package structure.union_find;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/11 20:31
 * @desc 快速合并--weight
 **/
public class UnionFind3 {
    private int[] parent;
    private int[] weight;
    private int size;

    public UnionFind3(int size) {
        this.parent = new int[size];
        this.weight = new int[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            this.parent[i] = i;
            this.weight[i] = 1;
        }
    }

    /**
     * 查找元素所属集合的头结点
     *
     * @param element
     * @return
     */
    public int find(int element) {
        while (element != parent[element]) {
            element = parent[element];
        }
        return element;
    }

    /**
     * 判断两个元素是否是一个集合
     *
     * @param firstElement
     * @param secondElement
     * @return
     */
    public boolean isConnected(int firstElement, int secondElement) {
        return find(firstElement) == find(secondElement);
    }

    public void unionElements(int firstElement, int secondElement) {
        int firstRoot = find(firstElement);
        int secondRoot = find(secondElement);
        if (firstRoot == secondRoot) {//已经是同一个集合的元素就不用再合并了
            return;
        }

        //集合的子元素多的头结点,合并之后仍然做头结点
        if (weight[firstRoot] > weight[secondRoot]) {
            parent[secondRoot] = firstRoot;
            weight[firstRoot] += weight[secondRoot];
        } else {
            parent[firstRoot] = secondRoot;
            weight[secondRoot] += weight[firstRoot];
        }
    }

    /**
     * 打印parent数组
     */
    public void printArray(int[] arr) {
        for (int parent : arr) {
            System.out.print(parent + "\t");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int n = 10;
        UnionFind3 union = new UnionFind3(n);

        System.out.println("初始parent：");
        union.printArray(union.parent);
        System.out.println("初始weight：");
        union.printArray(union.weight);

        System.out.println("连接了5 6 之后的parent：");
        union.unionElements(5, 6);
        union.printArray(union.parent);
        System.out.println("连接了5 6 之后的weight：");
        union.printArray(union.weight);

        System.out.println("连接了1 2 之后的parent：");
        union.unionElements(1, 2);
        union.printArray(union.parent);
        System.out.println("连接了1 2 之后的weight：");
        union.printArray(union.weight);

        System.out.println("连接了2 3 之后的parent：");
        union.unionElements(2, 3);
        union.printArray(union.parent);
        System.out.println("连接了2 3 之后的weight：");
        union.printArray(union.weight);

        System.out.println("连接了1 4 之后的parent：");
        union.unionElements(1, 4);
        union.printArray(union.parent);
        System.out.println("连接了1 4 之后的weight：");
        union.printArray(union.weight);

        System.out.println("连接了1 5 之后的parent：");
        union.unionElements(1, 5);
        union.printArray(union.parent);
        System.out.println("连接了1 5 之后的weight：");
        union.printArray(union.weight);

        System.out.println("1  6 是否连接：" + union.isConnected(1, 6));

        System.out.println("1  8 是否连接：" + union.isConnected(1, 8));
    }
}
