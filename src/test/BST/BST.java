package test.BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/13 10:52
 * @desc
 **/
public class BST<Key extends Comparable<Key>, Value> {

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }

        public Node(Node node) {
            this.key = node.key;
            this.value = node.value;
            this.left = null;
            this.right = null;
        }
    }

    private Node bRoot;
    private int size;

    public BST() {
        this.bRoot = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void preOrder() {
        preOrder(bRoot);
    }

    public void inOrder() {
        inOrder(bRoot);
    }

    public void postOrder() {
        postOrder(bRoot);
    }

    public Key minimum() {
        Node minimum = minimum(bRoot);
        return minimum.key;
    }

    public Key maximum() {
        Node maximum = maximum(bRoot);
        return maximum.key;
    }

    public boolean contain(Key key) {
        return contain(bRoot, key);
    }

    public Value search(Key key) {
        return search(bRoot, key);
    }

    public Node insert(Key key, Value value) {
        return insert(bRoot, key, value);
    }

    public void removeMax() {
        bRoot = removeMax(bRoot);
    }

    public void removeMin() {
        bRoot = removeMin(bRoot);
    }


    /*--------------------------BST核心函数--------------------------*/

    private Node remove(Node root, Key key) {
        if (root == null) {
            return null;
        }
        if (key.compareTo(root.key) < 0) {
            root.left = remove(root.left, key);
            return root;
        } else if (key.compareTo(root.key) > 0) {
            root.right = remove(root.right, key);
            return root.right;
        } else {
            if (root.left == null) {
                Node rightNode = root.right;
                root.right = null;
                size--;
                return root;
            }
            if (root.right == null) {
                Node leftNode = root.left;
                root.left = null;
                size--;
                return root;
            }
            Node min = new Node(minimum(root.right));
            size--;
            min.right = removeMin(root.right);
            min.left = root.left;
            size--;
            return min;
        }
    }

    private Node removeMax(Node root) {
        if (root.right == null) {
            Node leftRoot = root.left;
            root.left = null;
            size--;
            return leftRoot;
        }
        root.right = removeMax(root.right);
        return root;
    }

    private Node removeMin(Node root) {
        if (root.left == null) {
            Node rightRoot = root.right;
            root.right = null;
            size--;
            return rightRoot;
        }
        root.left = removeMin(root.left);
        return root;
    }

    private Node insert(Node root, Key key, Value value) {
        if (root == null) {
            root = new Node(key, value);
            size++;
            return root;
        }
        if (root.key.compareTo(key) == 0) {
            root.key = key;
        } else if (root.key.compareTo(key) > 0) {
            root.left = insert(root.left, key, value);
        } else {
            root.right = insert(root.right, key, value);
        }
        return root;
    }

    private void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.key);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.key);
            inOrder(root.right);
        }
    }

    private void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.key);
        }
    }

    private void levelOrder(Node root) {
        LinkedList<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.remove();
            System.out.println(node.key);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
    }

    private Node minimum(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private Node maximum(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    private boolean contain(Node root, Key key) {
        if (root == null) {
            return false;
        }
        if (root.key.compareTo(key) == 0) {
            return true;
        } else if (root.key.compareTo(key) > 0) {
            contain(root.left, key);
        } else {
            contain(root.right, key);
        }
        return false;
    }

    public Value search(Node root, Key key) {
        if (root == null) {
            return null;
        }
        if (root.key.compareTo(key) == 0) {
            return root.value;
        } else if (root.key.compareTo(key) > 0) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public static void main(String[] args) {
        BST b = new BST();
        b.bRoot = b.insert(8, 'E');
        b.bRoot = b.insert(2, "B");
        b.bRoot = b.insert(1, "A");
        b.bRoot = b.insert(3, "C");
        b.bRoot = b.insert(9, "F");
        b.levelOrder(b.bRoot);
    }
}
