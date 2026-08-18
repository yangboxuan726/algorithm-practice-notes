import java.util.List;

public class 回文链表 {
    //https://leetcode.cn/problems/palindrome-linked-list/description/?envType=study-plan-v2&envId=top-100-liked
    public static class ListNode {
        public int val;
        public ListNode next;
        ListNode(){};
        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    //方法一；递归
    private ListNode left;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return isPal(head);
    }
    public boolean isPal(ListNode right){
        if (right.next != null && !isPal(right.next)) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        left = left.next;
        return  true;
    }




    //方法二：更快
    public boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head,fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode pre = slow;
        ListNode cur = pre.next;
        ListNode next = null;
        pre.next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 上面的过程已经把链表调整成从左右两侧往中间指
        // head -> ... -> slow <- ... <- pre
        boolean ans = true;
        ListNode left = head;
        ListNode right = pre;
        while(left != null && right != null){
            if(left.val != right.val){
                ans = false;
            }
            left = left.next;
            right = right.next;
        }
        // 本着不坑的原则，把链表调整回原来的样子再返回判断结果
        cur = pre.next;
        pre.next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return ans;

    }
}
