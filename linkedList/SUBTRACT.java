package linkedList;

public class SUBTRACT {
    public ListNode subtract(ListNode A) {
        int size = listSize(A);
        int halfSize = size >> 1;//divide by 2

        ListNode rightHead = reverseHalf(A, halfSize);

        updateNewValue(A, rightHead);

        reverseHalfRight(rightHead);

        return A;
    }

    private int listSize(ListNode A){
        ListNode ptr = A;
        int n = 0;
        while(ptr != null){
            n++;
            ptr = ptr.next;
        }
        return n;
    }

    private ListNode reverseHalf(ListNode A, int inx){
        ListNode prev = null;
        ListNode curr = A;
        ListNode next = null;
        int count = 0;

        while(count < inx && curr != null){
            count++;
            curr = curr.next;
        }
        next = curr;
        while(curr != null){
            next = next.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private void updateNewValue(ListNode A, ListNode rightHead){
        ListNode left = A;
        ListNode right = rightHead;
        while (left != right && right != null){
            int update = right.val - left.val;
            left.val = update;
            left = left.next;
            right = right.next;
        }
    }

    private void reverseHalfRight(ListNode rightHead){
        ListNode pre = null;
        ListNode cur = rightHead;
        ListNode nex = rightHead;

        while (cur != null){
            nex = nex.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
    }
}
