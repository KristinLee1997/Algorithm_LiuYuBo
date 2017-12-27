package structure.union_find;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/11 22:20
 * @desc 快速合并--height
 **/
public class UnionFind4 {
    private int[] parent;
    private int[] height;
    int size;

    public UnionFind4(int size) {
        this.size = size;
        this.parent = new int[size];
        this.height = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            height[i] = 1;
        }
    }

    public int find(int element) {
        while (element != parent[element]) {
            element = parent[element];
        }
        return element;
    }

    public boolean isConnected(int firstElement, int secondElement) {
        return find(firstElement) == find(secondElement);

    }

    public void unionElements(int firstElement, int secondElement) {
        int firstRoot = find(firstElement);
        int secondRoot = find(secondElement);
        if (firstRoot == secondRoot) {
            return;
        }
        if (height[firstRoot] > height[secondRoot]) {
            parent[secondRoot] = firstRoot;
        } else if (height[firstRoot] < height[secondRoot]) {
            parent[firstRoot] = secondRoot;
        } else {
            parent[firstRoot] = secondRoot;
            height[secondRoot] += 1;
        }
    }

    private void printArray(int[] arr) {
        for (int parent : arr) {
            System.out.print(parent + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 10;
        UnionFind4 union = new UnionFind4(n);

        System.out.println("初始parent：");
        union.printArray(union.parent);
        System.out.println("初始height：");
        union.printArray(union.height);

        System.out.println("连接了5 6 之后的parent：");
        union.unionElements(5, 6);
        union.printArray(union.parent);
        System.out.println("连接了5 6 之后的height：");
        union.printArray(union.height);

        System.out.println("连接了1 2 之后的parent：");
        union.unionElements(1, 2);
        union.printArray(union.parent);
        System.out.println("连接了1 2 之后的height：");
        union.printArray(union.height);

        System.out.println("连接了2 3 之后的parent：");
        union.unionElements(2, 3);
        union.printArray(union.parent);
        System.out.println("连接了2 3 之后的height：");
        union.printArray(union.height);

        System.out.println("连接了1 4 之后的parent：");
        union.unionElements(1, 4);
        union.printArray(union.parent);
        System.out.println("连接了1 4 之后的height：");
        union.printArray(union.height);

        System.out.println("连接了1 5 之后的parent：");
        union.unionElements(1, 5);
        union.printArray(union.parent);
        System.out.println("连接了1 5 之后的height：");
        union.printArray(union.height);

        System.out.println("1  6 是否连接：" + union.isConnected(1, 6));

        System.out.println("1  8 是否连接：" + union.isConnected(1, 8));
    }
}
