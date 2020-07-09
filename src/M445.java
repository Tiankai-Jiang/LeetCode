import java.util.Stack;

public class M445 {

    // My solution
    private ListNode addTwoNumbers(Stack<ListNode> L, Stack<ListNode> S){
        int c = 0;
        ListNode res = null;
        while(!L.empty() && !S.empty()){
            int v1 = L.peek().val, v2 = S.pop().val;
            res = L.pop();
            res.val = (v1 + v2 + c)%10;
            c = (v1 + v2 + c)/10;
        }
        while(!L.empty()){
            int v1 = L.peek().val;
            res = L.pop();
            res.val = (v1+c)%10;
            c = (v1+c)/10;
        }
        return c == 0 ? res : new ListNode(c, res);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack(), s2 = new Stack<>();
        while(l1!=null){
            s1.push(l1);
            l1 = l1.next;
        }
        while(l2!=null){
            s2.push(l2);
            l2 =l2.next;
        }
        return s1.size()>=s2.size() ? addTwoNumbers(s1, s2) : addTwoNumbers(s2, s1);
    }
}
