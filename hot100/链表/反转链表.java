public class 反转链表 {
    // https://leetcode.cn/problems/reverse-linked-list/?envType=study-plan-v2&envId=top-100-liked
    /*
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        反转链表 solution = new 反转链表();
        ListNode newHead = solution.reverseList(head);
        printList(newHead);
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            // 改变 cur.next 前，先保存后面的链表，否则会找不到下一个节点。
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    private static void printList(ListNode head) {
        StringBuilder result = new StringBuilder();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (result.length() > 0) {
                result.append(' ');
            }
            result.append(cur.val);
        }
        System.out.println(result);
    }


    // 单链表节点
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    // 双链表节点
    public static class DoubleListNode {
        public int value;
        public DoubleListNode last;
        public DoubleListNode next;

        public DoubleListNode(int v) {
            value = v;
        }
    }

}
