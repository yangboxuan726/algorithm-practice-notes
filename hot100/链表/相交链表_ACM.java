import java.util.Scanner;

public class 相交链表_ACM {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int aLength = scanner.nextInt();
        int bLength = scanner.nextInt();
        int commonLength = scanner.nextInt();

        ListNode aPrefix = readList(scanner, aLength);
        ListNode bPrefix = readList(scanner, bLength);
        ListNode common = readList(scanner, commonLength);

        ListNode headA = connect(aPrefix, common);
        ListNode headB = connect(bPrefix, common);

        ListNode intersection = getIntersectionNode(headA, headB);
        System.out.println(intersection == null ? "null" : intersection.val);
    }

    private static ListNode readList(Scanner scanner, int length) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (int i = 0; i < length; i++) {
            tail.next = new ListNode(scanner.nextInt());
            tail = tail.next;
        }

        return dummy.next;
    }

    private static ListNode connect(ListNode prefix, ListNode common) {
        if (prefix == null) {
            return common;
        }

        ListNode tail = prefix;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = common;
        return prefix;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;

        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }

        return p;
    }
}
