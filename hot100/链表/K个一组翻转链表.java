public class K个一组翻转链表 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k){
        int n = 0;
        for (ListNode cur = head;cur != null;cur = cur.next){
            n++;
        }

        ListNode dummy = new ListNode(0,head);
        ListNode pre = null;
        ListNode p0 = dummy;
        ListNode cur = head;

        for (;n >= k;n = n - k){
            for (int i = 0;i < k ;i++){
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            ListNode temp = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = temp;

        }
        return dummy.next;
    }


}
