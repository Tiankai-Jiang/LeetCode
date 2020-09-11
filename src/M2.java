public class M2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        int carry = 0;
        ListNode res = new ListNode(0), cur = res;
        while(l1 != null && l2 != null){
            cur.next = new ListNode((l1.val+l2.val+carry)%10);
            carry = (l1.val+l2.val+carry)/10;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        if(l1 == null && l2 != null){
            while(l2!=null){
                cur.next = new ListNode((l2.val+carry)%10);
                carry = (l2.val+carry)/10;
                l2 = l2.next;
                cur = cur.next;
            }
        }else if(l1 != null){
            while(l1!=null){
                cur.next = new ListNode((l1.val+carry)%10);
                carry = (l1.val+carry)/10;
                l1 = l1.next;
                cur = cur.next;
            }

        }
        if(carry > 0) cur.next = new ListNode(carry);
        return res.next;
    }
}
