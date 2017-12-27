package Train;

import Train.Node;

import java.util.Arrays;
import java.util.List;

/**
 * @author LiHang
 * School: 哈尔滨理工大学
 * Saying: Never give up !!!
 * Date:   2017/11/29 20:34
 * Goal:    删除链表倒数第k个结点
 **/
public class RemoveNode {
    public static Node removeNthFromEnd(Node head, int n) {
        Node cur = head;
        int count = n;
        while (cur != null) {
            cur = cur.getNext();
            count--;
        }
        if (count > 0) {

        } else if (count == 0) {
            head = head.getNext();
        } else {
            cur = head;
            count++;
            while (count != 0) {
                count++;
                cur = cur.getNext();
            }
            cur.setNext(cur.getNext().getNext());
        }
        return head;
    }

    public static Node create(List<Integer> data) {
        if (data.isEmpty()) {
            return null;
        }
        Node firstNode = new Node(data.get(0));
        Node subList = create(data.subList(1, data.size()));
        firstNode.setNext(subList);
        return firstNode;
    }

    public static void display(Node head) {
        while (head != null) {
            System.out.print(head.getVal() + " ");
            head = head.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = create(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        removeNthFromEnd(head, 3);
        display(head);
    }
}
