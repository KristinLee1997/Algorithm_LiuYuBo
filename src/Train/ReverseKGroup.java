package Train;

import java.util.Arrays;
import java.util.List;

/**
 * @author 李航
 * @school 哈尔滨理工大学
 * @date 2017/12/9 12:40
 * @desc
 **/
public class ReverseKGroup {
    public static ListNode reverseTwoGroup(ListNode head) {
        ListNode temp;
        if (head == null || head.next == null) {
            return head;
        } else {
            temp = head.next;
            head.next = temp.next;
            temp.next = head;
            head = temp;
            head.next.next = reverseTwoGroup(head.next.next);
            return head;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 1;
        ListNode cur = head, ret = head, temp1 = null, temp2 = null, temp3 = null;
        while (count <= n) {
            if (count == m - 1) {
                ret = cur;
            }
            if (count == m) {
                temp2 = cur;
            }
            if (count == n) {
                temp1 = cur;
            }
            cur = cur.next;
            count++;
        }
        int diff = n - m;
        while (diff-- > 0) {
            temp3 = temp2.next;
            temp2.next = temp1;
            temp1 = temp2;
            temp2 = temp3;
            temp3=temp3.next;
        }
        ret.next = temp1;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.create(Arrays.asList(1, 2, 3, 4, 5, 6));
//        ListNode.print(head);
//        head = reverseTwoGroup(head);

        reverseBetween(head, 2, 5);
        ListNode.print(head);

    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public static ListNode create(List<Integer> data) {
        if (data.isEmpty()) {
            return null;
        }
        ListNode first = new ListNode(data.get(0));
        ListNode sublist = create(data.subList(1, data.size()));
        first.next = sublist;
        return first;
    }

    public static void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}