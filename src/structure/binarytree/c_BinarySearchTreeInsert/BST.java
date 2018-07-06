package structure.binarytree.c_BinarySearchTreeInsert;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/4 17:06
 * @desc 二叉搜索树--插入节点
 **/
public class BST<Key extends Comparable<? super Key>, Value> {
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    //向二叉搜索树中插入节点
    private Node insert(Node root, Key key, Value value) {
        //如果当前root为空时,说明已经找到应该插入的位置,而且二叉树中没有这个元素,此时应该新建一个节点,将其插入在这
        if (root == null) {
            size++;
            root = new Node(key, value);
        }
        if (key.compareTo(root.key) == 0) {//如果找到相等的值,则将其覆盖
            root.value = value;
        } else if (key.compareTo(root.key) < 0) {//如果key值小于root值,则root=root.left,去左子树中搜索
            root = insert(root.left, key, value);
        } else { //如果key值大于root值,root=root.right,则去由子树中搜索
            root = insert(root.right, key, value);
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
