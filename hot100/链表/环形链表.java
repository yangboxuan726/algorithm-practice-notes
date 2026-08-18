public class 环形链表 {
    //https://leetcode.cn/problems/linked-list-cycle/solutions/?envType=study-plan-v2&envId=top-100-liked
    class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public boolean hasCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return true;
            }
        }
        return  false;
    }

}
