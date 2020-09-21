import java.util.Stack;
public class E206 {

    // My solution 1, slow
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> s = new Stack<>();
        while(head != null){
            s.push(new ListNode(head.val));
            head = head.next;
        }
        ListNode a = new ListNode();
        ListNode start = a;
        while(!s.empty()){
            a.next = s.pop();
            a = a.next;
        }
        a.next = null;
        return start.next;
    }

    // My solution 2, slow
    public ListNode reverseList2(ListNode head) {
        if(head == null) return null;
        Stack<ListNode> s = new Stack<>();
        while(head != null){
            s.push(head);
            head = head.next;
        }
        ListNode a = s.pop();
        ListNode start = a;
        while(!s.empty()){
            a.next = s.pop();
            a = a.next;
        }
        a.next = null;
        return start;
    }

    // inplace iterative and recursive solution
    public ListNode reverseList3(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode nxt = head.next;
            head.next = newHead;
            newHead = head;
            head = nxt;
        }
        return newHead;
    }

    public ListNode reverseList4(ListNode head) {
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null) return newHead;
        ListNode nxt = head.next;
        head.next = newHead;
        return reverseListInt(nxt, head);
    }

    public ListNode reverseList5(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
