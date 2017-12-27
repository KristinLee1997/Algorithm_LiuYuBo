package structure.union_find;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/10 23:08
 * @desc 数组实现Union-Find:缺点是何冰效率太低了,合并一次就得全部遍历一次
 **/
public class UnionFind1 {
    private int[] parent;   //数组,表示并查集所有元素的集合号

    private int size;   //表示并查集元素个数

    public UnionFind1(int size) { //并查集初始化
        this.size = size;
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    /**
     * 查看元素所属集合
     *
     * @param element
     * @return
     */
    private int find(int element) {
        return parent[element];
    }

    /**
     * 判断两个集合是否在同一个集合
     *
     * @param firstElement
     * @param secondElement
     * @return
     */
    public boolean isConnected(int firstElement, int secondElement) {
        return find(firstElement) == find(secondElement);
    }

    /**
     * 合并firstElement,secondElement两个元素所在集合
     * 将firstElement集合中所有元素的集合号都变为secondElement,就是认为是将两个集合合并
     *
     * @param firstElement
     * @param secondElement
     */
    public void unionElements(int firstElement, int secondElement) {
        int firstUnion = find(firstElement);
        int secondUnion = find(secondElement);
        if (firstUnion != secondUnion) {
            for (int i = 0; i < size; i++) {
                if (parent[i] == firstUnion) {
                    parent[i] = secondUnion;
                }
            }
        }
    }

    private void printArray() {
        for (int id : this.parent) {
            System.out.print(id + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 10;
        UnionFind1 union = new UnionFind1(n);
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
