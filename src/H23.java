import java.util.*;

public class H23 {

    // My solution
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
        for(ListNode l : lists){
            while(l != null) {
                pq.offer(l);
                l = l.next;
            }
        }
        ListNode l = pq.poll(), a = l;
        while(!pq.isEmpty()){
            l.next = pq.poll();
            l = l.next;
        }
        if(l != null) l.next = null;
        return a;
    }

    // Another approach using pq
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists==null || lists.length==0) return null;
        PriorityQueue<ListNode> queue= new PriorityQueue<>(lists.length, Comparator.comparingInt(a -> a.val));
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        for (ListNode node:lists) if (node!=null) queue.add(node);
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            if (tail.next!=null) queue.add(tail.next);
        }
        return dummy.next;
    }
}
