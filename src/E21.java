public class E21 {

    // My solution
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2 == null) return null;
        else if(l1==null) return l2;
        else if(l2==null) return l1;
        else {
            if(l1.val <= l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            }else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }

    // Same idea less code
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)  return l1 == null ? l2 : l1;
        if (l1.val < l2.val) l1.next = mergeTwoLists(l1.next, l2);
        else l2.next = mergeTwoLists(l1, l2.next);
        return l1.val < l2.val ? l1 : l2;
    }
}
