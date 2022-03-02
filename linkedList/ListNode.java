package linkedList;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ListNode {

    public int val;
    public ListNode next;

    public static void print(ListNode head){
        while (head != null){
            System.out.print(" --> " + head.val);
            head = head.next;
        }
    }
}

