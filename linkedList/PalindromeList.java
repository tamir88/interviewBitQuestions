package linkedList;

public class PalindromeList {
    public int lPalin(ListNode A) {
        ListNode pivot = returnPointer(A);
        ListNode head = reverseList(pivot);
        return isPal(A, head);
    }

    private int isPal(ListNode a, ListNode b){
        while (a != null && b != null){
            if(a.val != b.val)
                return 0;
            a = a.next;
            b = b.next;
        }
        return 1;
    }

    private ListNode reverseList(ListNode h){
        ListNode p = null, c = h, n = null;
        while(c != null){
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        h = p;
        return h;
    }


    private ListNode returnPointer(ListNode h){
        ListNode fast = h;
        ListNode slow = h;

        while ( fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1,new ListNode(2,new ListNode(1,null)));
        PalindromeList b = new PalindromeList();
        System.out.println(b.lPalin(a));
    }

}
