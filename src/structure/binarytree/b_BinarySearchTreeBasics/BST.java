package structure.binarytree.b_BinarySearchTreeBasics;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/4 17:00
 * @desc 基本二插搜索树
 **/
public class BST<Key extends Comparable<Key>, Value> {
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
