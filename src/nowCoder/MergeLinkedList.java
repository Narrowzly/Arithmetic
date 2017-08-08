package nowCoder;

public class MergeLinkedList {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode pre = null;
        ListNode next = null;
        ListNode start = null;
        while(list1!=null||list2!=null) {
            if(list1==null) {
                next = list2;
                list2 = list2.next;
            }
            else if(list2==null)  {
                next = list1;
                list1 = list1.next;
            }else if(list1.val<=list2.val) {
                next = list1;
                list1 = list1.next;
            }else {
                next = list2;
                list2 = list2.next;
            }if(start!=null){
                pre.next = next;
                pre = next;
            }else{
                pre = next;
                start = pre;
            }
        }
        return start;
    }
}