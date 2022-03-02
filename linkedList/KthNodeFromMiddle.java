package linkedList;

public class KthNodeFromMiddle {
    public int solve(ListNode A, int B) {
        ListNode ptr = A;
        int N = 0;
        int mid;
        int inx;

        while (ptr != null){
            N++;
            ptr = ptr.next;
        }
        mid = (N>>1) + 1;
        inx = mid - B - 1;
        if(inx < 0)
            return -1;
        ptr = A;
        while (inx > 0){
            ptr = ptr.next;
            inx--;
        }
        return ptr.val;
    }

    public static void main(String[] args) {
        KthNodeFromMiddle a = new KthNodeFromMiddle();
        System.out.println(a.solve(new ListNode(1,new ListNode(14,new ListNode(6,new ListNode(16,new ListNode(4,new ListNode(10,null)))))),2));
    }

}
