package linkedList;

public class ReverseAlternateKNodes {
    public ListNode solve(ListNode A, int B) {
        ListNode demiNode = new ListNode(-1,null);
        ListNode prev = null;
        ListNode curr = A;
        ListNode next = A;
        ListNode tail = A;
        ListNode head = demiNode;
        int count = 0;

        demiNode.next = A;
        A = demiNode;

        while (curr != null){
            while (curr != null && count < B) {
                next = next.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            head.next = prev;
            tail.next = curr;
            count = 0;
            while (curr != null && count < B) {
                head = curr;
                curr = curr.next;
                count++;
            }
            next = curr;
            tail = curr;
            prev = null;
            count = 0;
        }
        return A.next;
    }
}
