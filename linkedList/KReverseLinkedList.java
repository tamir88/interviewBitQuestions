package linkedList;

public class KReverseLinkedList {
    public ListNode reverseList(ListNode A, int B) {
        //base case
        if(A.next == null)  return A;
        ListNode prev = null;
        ListNode curr = A;
        ListNode next = A;
        ListNode h1 = A;
        ListNode h2 = A;
        ListNode ptr = A;
        int count = 0;
        int size = 0;

        while (ptr != null){
            size++;
            ptr = ptr.next;
        }

        while(curr != null && count < B){
            next = next.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        A = prev;
        prev = null;
        count = 0;

        for (int i = 0; i <(size/B) ; i++) {
            h2 = curr;
            while(curr != null && count < B){
                next = next.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            h1.next = prev;
            h1 = h2;
            prev = null;
            count = 0;
        }
        return A;
    }

    public static void main(String[] args) {
        KReverseLinkedList a = new KReverseLinkedList();
        ListNode.print(a.reverseList(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6,null)))))),2));

    }

}
