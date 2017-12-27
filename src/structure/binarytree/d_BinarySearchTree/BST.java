package structure.binarytree.d_BinarySearchTree;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/4 17:50
 * @desc
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

    public boolean contain(Key key) {
        return contain(root, key);
    }

    public Value search(Key key) {
        return search(root, key);
    }

    //以root为根节点的二叉树中是否存在键为key的结点,返回结点的value
    private Value search(Node root, Key key) {
        if (root == null) {
            return null;
        }
        if (key.compareTo(root.key) == 0) {
            return root.value;
        } else if (key.compareTo(root.key) < 0) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    //以root为根节点的二叉树中是否存在键为key的结点,返回true/false
    private boolean contain(Node root, Key key) {
        if (root == null) {
            return false;
        }
        if (root.value == key) {
            return true;
        } else if (key.compareTo(root.key) < 0) {
            return contain(root.left, key);
        } else {
            return contain(root.right, key);
        }
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
        int N = 1000000;

        // 创建一个数组，包含[0...N)的所有元素
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++)
            arr[i] = new Integer(i);

        // 打乱数组顺序
        for (int i = 0; i < N; i++) {
            int pos = (int) (Math.random() * (i + 1));
            Integer t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = arr[pos];
        }
        // 由于我们实现的二分搜索树不是平衡二叉树，
        // 所以如果按照顺序插入一组数据，我们的二分搜索树会退化成为一个链表
        // 平衡二叉树的实现，我们在这个课程中没有涉及，
        // 有兴趣的同学可以查看资料自学诸如红黑树的实现
        // 以后有机会，我会在别的课程里向大家介绍平衡二叉树的实现的：）


        // 我们测试用的的二分搜索树的键类型为Integer，值类型为String
        // 键值的对应关系为每个整型对应代表这个整型的字符串
        BST<Integer, String> bst = new BST<Integer, String>();
        for (int i = 0; i < N; i++)
            bst.insert(new Integer(arr[i]), Integer.toString(arr[i]));

        // 对[0...2*N)的所有整型测试在二分搜索树中查找
        // 若i在[0...N)之间，则能查找到整型所对应的字符串
        // 若i在[N...2*N)之间，则结果为null
        for (int i = 0; i < 2 * N; i++) {
            String res = bst.search(new Integer(i));
            if (i < N)
                assert res.equals(Integer.toString(i));
            else
                assert res == null;
        }
    }
}
