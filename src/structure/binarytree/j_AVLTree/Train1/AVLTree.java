package structure.binarytree.j_AVLTree.Train1;

/**
 * author 李航
 * school 哈尔滨理工大学
 * date 2017/12/8 1:14
 * desc
 **/
public class AVLTree<T extends Comparable<T>> {
    private Node<T> root;

    class Node<T extends Comparable<T>> {
        T key;
        int height;
        Node<T> left;
        Node<T> right;

        public Node(T key, Node left, Node right) {
            this.key = key;
            this.height = 0;
            this.left = left;
            this.right = right;
        }
    }

    public AVLTree() {
        this.root = null;
    }

    //获取树的高度
    public int getHeight() {
        return getHeight(root);
    }

    //先序遍历AVL树
    public void preOrder() {
        preOrder(root);
    }

    //中序遍历AVL树
    public void inOrder() {
        inOrder(root);
    }

    //后序遍历AVL树
    public void postOrder() {
        postOrder(root);
    }

    //获得树中的值最小结点--递归
    public T minimum() {
        Node<T> p = minimum(root);
        if (p != null) {
            return p.key;
        }
        return null;
    }

    //获得树中值最大结点--递归
    public T maximum() {
        Node<T> p = maximum(root);
        if (p != null) {
            return p.key;
        }
        return null;
    }

    //查找并返回树中值为key的结点--递归
    public Node search(T key) {
        return search(root, key);
    }

    //查找并返回树中值为key的结点--迭代
    public Node iterativeSearch(T key) {
        return iterativeSearch(root, key);
    }

    //在AVLTree中插入一个结点,并且调节AVLTree平衡
    public void insert(T key) {
        root = insert(root, key);
    }

    //删除AVLTree中值为key的结点,并且调节AVLTree平衡
    public void remove(T key) {
        Node<T> target;
        if ((target = search(key)) != null) {
            root = remove(root, target);
        }
    }

    //销毁AVLTree
    public void destory() {
        destory(root);
    }

    public void print() {
        if (root != null) {
            print(root, root.key, 0);
        }
    }

    /**
     * 核心函数
     */

    private void print(Node<T> root, T key, int direction) {
        if (root != null) {
            if (direction == 0) {
                System.out.printf("%2d is root\n", root.key, key);
            } else {
                System.out.printf("%2d is %2d's %6s child\n", root.key, key, direction == 1 ? "right" : "left");
            }
            print(root.left, root.key, -1);
            print(root.right, root.key, 1);
        }
    }

    private void destory(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            destory(root.left);
        }
        if (root.right != null) {
            destory(root.right);
        }
        root = null;
    }

    private Node<T> remove(Node<T> root, Node<T> target) {
        //当树为空或者没有找到要删除的结点是时,应该返回root
        if (root == null || target == null) {
            return root;
        }
        if (target.key.compareTo(root.key) < 0) {
            root.left = remove(root.left, target);
            if (getHeight(root.right) - getHeight(root.left) == 2) {
                Node<T> newRight = root.right;
                if (getHeight(newRight.left) > (getHeight(newRight.right))) {
                    root = rightLeftRotation(root);
                } else {
                    root = rightRightRotation(root);
                }
            }
        } else if (target.key.compareTo(root.key) > 0) {
            root.right = remove(root.right, target);
            if (getHeight(root.left) - getHeight(root.right) == 2) {
                Node newLeft = root.left;
                if (getHeight(newLeft.left) < getHeight(newLeft.right)) {
                    root = leftRightRotation(root);
                } else {
                    root = leftLeftRotation(root);
                }
            }
        } else {
            if (root.left != null && root.right != null) {
                if (getHeight(root.left) > getHeight(root.right)) {
                    Node<T> max = maximum(root.left);
                    root.key = max.key;
                    root.left = remove(root.left, max);
                } else {
                    Node<T> min = minimum(root.right);
                    root.key = min.key;
                    root.right = remove(root.right, min);
                }
            } else {
                Node<T> temp = root;
                root = (root.left != null) ? root.left : root.right;
                temp = null;
            }
        }
        return root;
    }

    private Node<T> insert(Node<T> root, T key) {
        if (root == null) {
            root = new Node<T>(key, null, null);
            if (root == null) {
                System.out.println("结点创建失败");
                return null;
            }
        } else {
            if (key.compareTo(root.key) < 0) {
                root.left = insert(root.left, key);
                //插入结点后,AVLTree失去平衡
                if (getHeight(root.left) - getHeight(root.right) == 2) {
                    if (key.compareTo(root.left.key) < 0) {
                        root = leftLeftRotation(root);
                    } else {
                        root = leftRightRotation(root);
                    }
                }
            } else if (key.compareTo(root.key) > 0) {
                root.right = insert(root.right, key);
                if (getHeight(root.right) - getHeight(root.left) == 2) {
                    if (key.compareTo(root.right.key) > 0) {
                        root = rightRightRotation(root);
                    } else {
                        root = rightLeftRotation(root);
                    }
                }
            } else {
                System.out.println("添加失败,存在相同结点");
            }
        }
        root.height = max(getHeight(root.left), getHeight(root.right)) + 1;
        return root;
    }

    // 左左结构:右旋
    //           7                4
    //          /  \            /   \
    //         4    A          2     7
    //       /   \            /  \  /  \
    //      2     B          C   D B    A
    //     /  \
    //    C    D
    private Node leftLeftRotation(Node<T> root) {
        Node newRoot = root.left;

        root.left = newRoot.right;
        newRoot.right = root;
        root.height = max(getHeight(root.left), getHeight(root.right)) + 1;
        newRoot.height = max(getHeight(newRoot.left), root.height) + 1;
        return newRoot;
    }

    //右右结构:左旋
    //       3                       5
    //      /  \                   /   \
    //     A    5                 3      7
    //         / \              /  \    /  \
    //        B   7            A   B   C    D
    //           / \
    //          C   D
    //
    private Node rightRightRotation(Node<T> root) {
        Node newRoot = root.right;

        root.right = newRoot.left;
        newRoot.left = root;
        root.height = max(getHeight(root.left), getHeight(root.right)) + 1;
        newRoot.height = max(getHeight(newRoot.right), root.height) + 1;
        return newRoot;
    }

    //左右结构:先对root.left左旋,然后root右旋
    //          5                5                 4
    //        /   \            /   \             /   \
    //      3      A          4     A           3     5
    //    /   \             /  \               / \   / \
    //   B     4           3    D             B   C D   A
    //        /  \        / \
    //       C    D      B  C
    private Node leftRightRotation(Node<T> root) {
        root.left = rightRightRotation(root.left);
        return leftLeftRotation(root);
    }

    //右左结构:先对root.right右旋,然后对root左旋
    //          3                 3                      4
    //        /   \             /   \                  /   \
    //       A     5           A     4                3     5
    //            /  \             /   \             / \   / \
    //           4    B           C     5           A  C  D   B
    //         /  \                    /  \
    //        C    D                  D    B
    private Node rightLeftRotation(Node<T> root) {
        root.right = leftLeftRotation(root.right);
        return rightRightRotation(root);
    }

    private Node iterativeSearch(Node<T> root, T key) {
        while (root != null) {
            if (key.compareTo(root.key) < 0) {
                root = root.left;
            } else if (key.compareTo(root.key) > 0) {
                root = root.right;
            } else {
                return root;
            }
        }
        return root;
    }

    private Node search(Node<T> root, T key) {
        if (root == null) {
            return root;
        }
        if (key.compareTo(root.key) < 0) {
            return search(root.left, key);
        } else if (key.compareTo(root.key) > 0) {
            return search(root.right, key);
        } else {
            return root;
        }
    }

    private Node<T> maximum(Node<T> root) {
        if (root == null) {
            return root;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    private Node<T> minimum(Node<T> root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
    }

    private void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.key + " ");
        }
    }

    private int getHeight(Node root) {
        if (root != null) {
            return root.height;
        }
        return 0;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        int arr[] = {3, 2, 1, 4, 5, 6, 7, 16, 15, 14, 13, 12, 11, 10, 8, 9};
        int i;
        AVLTree<Integer> tree = new AVLTree<Integer>();

        System.out.printf("== 依次添加: ");
        for (i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
            tree.insert(arr[i]);
        }

        System.out.printf("\n== 前序遍历: ");
        tree.preOrder();

        System.out.printf("\n== 中序遍历: ");
        tree.inOrder();

        System.out.printf("\n== 后序遍历: ");
        tree.postOrder();
        System.out.printf("\n");

        System.out.printf("== 高度: %d\n", tree.getHeight());
        System.out.printf("== 最小值: %d\n", tree.minimum());
        System.out.printf("== 最大值: %d\n", tree.maximum());
        System.out.printf("== 树的详细信息: \n");
        tree.print();

        i = 8;
        System.out.printf("\n== 删除根节点: %d", i);
        tree.remove(i);

        System.out.printf("\n== 高度: %d", tree.getHeight());
        System.out.printf("\n== 中序遍历: ");
        tree.inOrder();
        System.out.printf("\n== 树的详细信息: \n");
        tree.print();

        // 销毁二叉树
        tree.destory();
    }
}
