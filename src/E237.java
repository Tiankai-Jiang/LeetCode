public class E237 {

    // My solution
    public void deleteNode(ListNode node) {
        ListNode n = new ListNode();
        while(node.next != null) {
            node.val = node.next.val;
            n = node;
            node = node.next;
        }
        n.next = null;
    }
}
