package linkedList;

public class AddTwoNumbersAsLists {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode head = null;
        ListNode pt = head;
        boolean remainder = false;
        int sum = 0;


            sum = A.val + B.val;
            if(remainder) {
                sum++;
                remainder = false;
            }
            if (sum > 9) {
                sum = sum - 10;
                remainder = true;
            }
            head = new ListNode(sum,null);
            pt = head;
            A = A.next;
            B = B.next;

        while (A != null && B != null){
            sum = A.val + B.val;
            if(remainder) {
                sum++;
                remainder = false;
            }
            if (sum > 9) {
                sum = sum - 10;
                remainder = true;
            }
            pt.next = new ListNode(sum,null);
            pt = pt.next;
            A = A.next;
            B = B.next;
        }
        while (A != null){
            if(remainder){
                sum = A.val + 1;
                remainder = false;
            }
            if (sum > 9) {
                sum = sum - 10;
                remainder = true;
            }
            pt.next = new ListNode(sum,null);
            pt = pt.next;
            A = A.next;
        }
        while (B != null){
            if(remainder){
                sum = B.val + 1;
                remainder = false;
            }
            if (sum > 9) {
                sum = sum - 10;
                remainder = true;
            }
            pt.next = new ListNode(sum,null);
            pt = pt.next;
            B = B.next;
        }
        if(remainder)
            pt.next = new ListNode(1,null);

        return head;
    }

    public static void main(String[] args) {
        AddTwoNumbersAsLists a = new AddTwoNumbersAsLists();
        ListNode.print(a.addTwoNumbers(new ListNode(9,new ListNode(9, new ListNode(1,null))),new ListNode(1,null)));

    }

}
