public class M24 {

    // My solution
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next == null) return head;
        ListNode tmp = head.next, tmp2 = tmp.next;
        tmp.next = head;
        tmp.next.next = swapPairs(tmp2);
        return tmp;
    }
}
