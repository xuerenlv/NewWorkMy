package leetcode_final;

/**
 * Created by Xuehj on 16/7/10.
 */
public class Odd_Even_Linked_List_328 {
    public static void main(String[] a){
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode xx = new Solution_Odd_Even_Linked_List_328().oddEvenList(head);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}




class Solution_Odd_Even_Linked_List_328 {

    public ListNode oddEvenList_other(ListNode head) {
        if (head != null) {

            ListNode odd = head, even = head.next, evenHead = even;

            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
        }
        return head;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head==null || head.next==null)
            return head;
        ListNode head_odd = head,head_even = head.next;
        ListNode tail_odd = head,tail_even = head.next;
        ListNode p = head.next.next,s;

        boolean odd = true;
        while (p!=null){
            s=p.next;
            p.next=null;
            if (odd){
                tail_odd.next=p;
                tail_odd=p;
            }else{
                tail_even.next=p;
                tail_even=p;
            }
            odd=!odd;
            p=s;
        }

        tail_odd.next=head_even;
        return  head;
    }
}
