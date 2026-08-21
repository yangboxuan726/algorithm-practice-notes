import java.util.HashMap;
import java.util.Map;

public class 随机链表的复制 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode random;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode copyRandomList(ListNode head) {
        if (head == null) return null;

        Map<ListNode, ListNode> map = new HashMap<>();

        ListNode cur = head;

        // 第一遍：复制所有节点
        while (cur != null) {
            map.put(cur, new ListNode(cur.val));
            cur = cur.next;
        }

        // 第二遍：连接 next 和 random
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);

            cur = cur.next;
        }

        return map.get(head);
    }
}