public class M328 {

    // My solution
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next==null || head.next.next==null) return head;
        ListNode a = head, oddHead = head, evenHead=head.next;
        while(evenHead!= null && evenHead.next!=null){
            ListNode toMove = evenHead.next;
            evenHead.next = toMove.next;
            toMove.next = oddHead.next;
            oddHead.next = toMove;
            oddHead = oddHead.next;
            evenHead = evenHead.next;
        }
        return a;
    }

    // Another solution
    public ListNode oddEvenList2(ListNode head) {
        if (head != null) {
            ListNode odd = head, even = head.next, evenHead = even;
            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }
        return head;
    }
}
