package linkedList;


public class PartitionList {
    public ListNode partition(ListNode A, int B) {
        ListNode smaller = null;
        ListNode greater = null;
        ListNode ptr_s = null;
        ListNode ptr_g = null;

        while (A != null){
            if(A.val < B){
                if(smaller == null){
                    smaller = A;
                }
                else {
                    ptr_s.next = A;
                }
                ptr_s = A;
            }
            else{
                if(greater == null){
                    greater = A;
                }
                else{
                    ptr_g.next = A;
                }
                ptr_g = A;
            }
            A = A.next;
        }
        if(ptr_g != null)
            ptr_g.next = null;
        if(ptr_s != null)
            ptr_s.next = greater;
        return (smaller == null) ? greater : smaller;
    }


    public static void main(String[] args) {
        PartitionList a = new PartitionList();
        ListNode.print(a.partition(new ListNode(1,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(5,new ListNode(2,null)))))),3));
    }


}
