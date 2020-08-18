import java.util.*;
public class M143 {
    public void reorderList(ListNode head) {
        if(head == null) return;
        Deque<ListNode> dq = new LinkedList<>(), dq2 = new LinkedList<>();
        while(head != null){
            dq.add(head);
            head = head.next;
        }

        while(!dq.isEmpty()){
            if(!dq2.isEmpty()) dq2.getLast().next = dq.getFirst();

            dq2.addLast(dq.pollFirst());
            if(!dq.isEmpty()){
                dq2.getLast().next = dq.getLast();
                dq2.addLast(dq.pollLast());
            }
        }
        dq2.getLast().next = null;
    }

    public void reorderList2(ListNode head) {
        if(head==null||head.next==null) return;

        //Find the middle of the list
        ListNode p1=head, p2=head;
        while(p2.next!=null&&p2.next.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }

        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle=p1, preCurrent=p1.next;
        while(preCurrent.next!=null){
            ListNode current=preCurrent.next;
            preCurrent.next=current.next;
            current.next=preMiddle.next;
            preMiddle.next=current;
        }

        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        p1=head;
        p2=preMiddle.next;
        while(p1!=preMiddle){
            preMiddle.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=preMiddle.next;
        }
    }
}
