package structure.union_find;

import java.util.Scanner;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/11 22:51
 * @desc
 **/
public class Main {
    private int[] parent;
    private int[] weight;
    private int size;
    private int groups;

    public Main(int size) {
        this.size = size;
        this.groups = size;
        this.parent = new int[size];
        this.weight = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            weight[i] = 1;
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

    public void unionElement(int firstElement, int secondElement) {
        int firstRoot = find(firstElement);
        int secondRoot = find(secondElement);
        if (firstRoot == secondRoot) {
            return;
        }
        if (weight[firstRoot] < weight[secondRoot]) {
            parent[firstRoot] = secondRoot;
            weight[secondRoot] += weight[firstRoot];
        } else {
            parent[secondRoot] = firstRoot;
            weight[firstRoot] += weight[secondRoot];
        }
        this.groups--;
    }

    public int getGroups() {
        return this.groups;
    }

    public void printArray(int[] arr) {
        for (int parent : arr) {
            System.out.print(parent + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int N = scan.nextInt();
            Main m = new Main(N);
            int M = scan.nextInt();
            for (int j = 0; j < M; j++) {
                int a = scan.nextInt()-1;
                int b = scan.nextInt()-1;
                m.unionElement(a, b);
            }
            System.out.println(m.getGroups());
        }
    }
}
