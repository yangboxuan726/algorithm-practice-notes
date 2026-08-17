public class 相交链表 {
    //https://leetcode.cn/problems/intersection-of-two-linked-lists/?envType=study-plan-v2&envId=top-100-liked
    /*
    给你两个单链表的头节点 headA 和 headB，请你找出并返回两条单链表相交的起始节点。
    如果两条链表没有交点，返回 null。
    示例：listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]，两条链共享尾部 8->4->5
    输出：Intersected at '8'
    */
    public static void main(String[] args) {
        //手动构造：让同一个 common 对象同时挂在两条链上，这就是"相交"
        //headA: 4 -> 1 \
        //                8 -> 4 -> 5   (common)
        //headB: 5 -> 6 -> 1 /
        ListNode common = new ListNode(8, new ListNode(4, new ListNode(5)));
        ListNode headA = new ListNode(4, new ListNode(1, common));
        ListNode headB = new ListNode(5, new ListNode(6, new ListNode(1, common)));

        相交链表 solution = new 相交链表();
        ListNode ans = solution.getIntersectionNode(headA, headB);
        System.out.println(ans == null ? "null" : "Intersected at '" + ans.val + "'");
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
