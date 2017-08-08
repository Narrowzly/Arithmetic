package nowCoder;

public class Reverse {
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while(head!=null) {
            next = head.next;
            head.next = pre;//当前节点的下一个是之前的那个节点 (头插法)
            pre = head;
            head = next;
        }
        return pre;
    }
}
