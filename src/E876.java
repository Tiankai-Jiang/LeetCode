public class E876 {

    // My solution
    public ListNode middleNode(ListNode head) {
        int c = 1;
        ListNode a = head;
        while(head.next != null){
            c++;
            head = head.next;
        }
        for(int i = 0; i < c/2; ++i) a = a.next;
        return a;
    }

    // use slow and fast pointer
    public ListNode middleNode2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
