import java.util.Scanner;

public class 反转链表_ACM {
    // https://leetcode.cn/problems/reverse-linked-list/?envType=study-plan-v2&envId=top-100-liked
    /*
     * ACM 输入格式（支持读到 EOF 的多组数据）：
     * n
     * n 个节点值
     *
     * 示例输入：
     * 5
     * 1 2 3 4 5
     * 2
     * 1 2
     *
     * 示例输出：
     * 5 4 3 2 1
     * 2 1
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            ListNode head = buildList(sc, n);
            ListNode newHead = reverseList(head);
            printList(newHead);
        }

        sc.close();
    }

    // 尾插法建链。dummy 是辅助节点，dummy.next 才是真正的头节点。
    private static ListNode buildList(Scanner sc, int n) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (int i = 0; i < n; i++) {
            tail.next = new ListNode(sc.nextInt());
            tail = tail.next;
        }

        return dummy.next;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    // 按 ACM 常见格式输出，节点之间只有一个空格，没有方括号和逗号。
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

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
