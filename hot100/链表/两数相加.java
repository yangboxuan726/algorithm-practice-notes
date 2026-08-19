public class 两数相加 {
    //https://leetcode.cn/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-100-liked
    static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode();
        ListNode  cur = dummy;

        int carry = 0;//进位

        while(l1 != null || l2 != null || carry != 0){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + carry;

           cur.next = new ListNode(sum % 10);

           carry = sum / 10;

           cur = cur.next;

           if (l1 != null){
               l1 = l1.next;
           }
           if (l2 != null){
               l2 = l2.next;
           }

        }
        return  dummy.next;

    }
}
