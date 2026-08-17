import java.util.Scanner;

public class 相交链表_ACM {
    //https://leetcode.cn/problems/intersection-of-two-linked-lists/?envType=study-plan-v2&envId=top-100-liked
    /*
    ACM 输入格式（每组数据一行四个整数 + 两行链表）：
    n m skipA skipB   —— A、B 的节点总数；交点之前 A、B 各自有几个节点
    n 个整数           —— 链表 A 的值（包含公共尾部）
    m 个整数           —— 链表 B 的值（包含公共尾部）
    不相交时 skipA == n 且 skipB == m（公共段为空），约定输出 0

    示例输入：
    5 6 2 3
    4 1 8 4 5
    5 6 1 8 4 5
    3 3 3 3
    2 6 4
    1 5 9
    示例输出：
    8
    0
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int skipA = sc.nextInt();
            int skipB = sc.nextInt();

            //1. 尾插法建链（所有链表题通用的建链模板）
            ListNode headA = buildList(sc, n);
            ListNode headB = buildList(sc, m);

            //2. A 从头走 skipA 步，正好落在交点上（不相交则落在 null）
            ListNode intersect = headA;
            for (int i = 0; i < skipA; i++) {
                intersect = intersect.next;
            }

            //3. B 的前 skipB 个节点是自己的前缀，把前缀的尾巴接到交点上
            //   skipB == 0 时 B 的头本身就是交点，直接换头
            if (skipB == 0) {
                headB = intersect;
            } else {
                ListNode tailB = headB;
                for (int i = 1; i < skipB; i++) {
                    tailB = tailB.next;
                }
                tailB.next = intersect;
            }

            //4. 建链完成，之后和核心代码版完全一样
            ListNode ans = getIntersectionNode(headA, headB);
            System.out.println(ans == null ? 0 : ans.val);
        }
        sc.close();
    }

    //尾插法：顺序读 n 个数依次接到尾巴后面，dummy.next 即真正的头节点
    private static ListNode buildList(Scanner sc, int n) {
        ListNode dummy = new ListNode(0); //哑节点，省去对"头节点为空"的特判
        ListNode tail = dummy;
        for (int i = 0; i < n; i++) {
            tail.next = new ListNode(sc.nextInt());
            tail = tail.next;
        }
        return dummy.next;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        while(p != q){
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;

        }
        return p;

    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
}
