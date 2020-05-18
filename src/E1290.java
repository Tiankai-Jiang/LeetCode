public class E1290 {

    // My solution
    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while(head != null){
            sb.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    // Use bit operation
    public int getDecimalValue2(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = (ans << 1) | head.val;
            head = head.next;
        }
        return ans;
    }
}
