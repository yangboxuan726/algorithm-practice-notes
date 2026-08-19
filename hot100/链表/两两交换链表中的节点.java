public class 两两交换链表中的节点 {
    //https://leetcode.cn/problems/swap-nodes-in-pairs/description/?envType=study-plan-v2&envId=top-100-liked
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head){
        ListNode dummy = new ListNode(0,head);
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null){
            ListNode first = cur.next;
            ListNode second = cur.next.next;

            first.next = second.next;
            second.next = first;
            cur.next = second;

            cur = first;

        }
        return dummy.next;

    }

}
