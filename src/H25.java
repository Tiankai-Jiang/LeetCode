public class H25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        if(k==1) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pre = dummy, start = head, then = head.next, forward = dummy;
        while(true){
            boolean nextRound = true;
            for(int i=0; i<k; i++){
                forward = forward.next;
                if(forward == null) {
                    nextRound = false;
                    break;
                }
            }
            if(!nextRound) break;
            for(int i=0; i<k-1; i++){
                start.next = then.next;
                then.next = pre.next;
                pre.next = then;
                then = start.next;
            }
            if(then == null) break;
            forward = start;
            pre = start;
            start = then;
            then = then.next;
        }
        return dummy.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }
}
