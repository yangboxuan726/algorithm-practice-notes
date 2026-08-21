public class 排序链表 {
    //https://leetcode.cn/problems/sort-list/?envType=study-plan-v2&envId=top-100-liked
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public ListNode sortList(ListNode head){
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode right = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        right = sortList(right);

        return merge(left, right);

    }

    public ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while(l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return  dummy.next;
    }


}
