package structure.union_find;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/11 19:15
 * @desc 快速合并
 **/
public class UnionFind2 {
    private int[] parent;
    private int size;

    public UnionFind2(int size) { //初始化并查集
        this.size = size;
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    /**
     * 查找element集合的头结点
     * element=parent[element]:说明element元素是一个集合的头结点或者是自己一个集合
     *
     * @param element
     * @return
     */
    public int find(int element) {
        while (element != parent[element]) {//此时说明element已不是自己一个结点了,所以通过循环找寻element所属集合的头结点
            element = parent[element];
        }
        return element;  //
    }

    /**
     * 判断两个元素是否是一个集合:只需要判断两个元素所属集合的头结点是否相同即可
     *
     * @param firstElement
     * @param secondElement
     * @return
     */
    public boolean isConnected(int firstElement, int secondElement) {
        int firstUnion = find(firstElement);
        int secondUnion = find(secondElement);
        return firstUnion == secondUnion;
    }

    /**
     * 合并firstElement,secondElement所在的两个集合
     * 将firstElement集合的头结点指向secondElement集合的头结点
     *
     * @param firstElement
     * @param secondElement
     */
    public void unionElements(int firstElement, int secondElement) {
        int firstUnion = find(firstElement);
        int secondUnion = find(secondElement);
        if (firstUnion != secondUnion) {
            parent[firstElement] = secondUnion;
        }
    }

    /**
     * 打印每个元素所属集合的小组号,即它的上一个结点号
     */
    private void printArray() {
        for (int parent : parent) {
            System.out.print(parent + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 10;
        UnionFind2 union = new UnionFind2(n);
        System.out.println("初始：");
        union.printArray();

        System.out.println("连接了5 6");
        union.unionElements(5, 6);
        union.printArray();

        System.out.println("连接了1 2");
        union.unionElements(1, 2);
        union.printArray();

        System.out.println("连接了2 3");
        union.unionElements(2, 3);
        union.printArray();

        System.out.println("连接了1 4");
        union.unionElements(1, 4);
        union.printArray();

        System.out.println("连接了1 5");
        union.unionElements(1, 5);
        union.printArray();

        System.out.println("1  6 是否连接：" + union.isConnected(1, 6));

        System.out.println("1  8 是否连接：" + union.isConnected(1, 8));
    }
}
