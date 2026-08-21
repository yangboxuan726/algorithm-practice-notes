import java.util.PriorityQueue;

public class 合并K个升序链表 {
    //https://leetcode.cn/problems/merge-k-sorted-lists/?envType=study-plan-v2&envId=top-100-liked
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public ListNode mergeKLists(ListNode[] lists){
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b)->a.val - b.val);

        for (ListNode node : lists){
            if (node != null){
                heap.add(node);
            }
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (!heap.isEmpty()){
            ListNode node = heap.poll();

            cur.next = node;
            cur = cur.next;
            if (node.next != null){
                heap.add(node.next);
            }
        }
        return  dummy.next;
    }
}
