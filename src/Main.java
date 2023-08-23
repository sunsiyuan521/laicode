import Kway.MergeKSortedLists;
import PublicClass.ListNode;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(7);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(5);
        list2.next.next = new ListNode(8);

        ListNode list3 = new ListNode(3);
        list3.next = new ListNode(6);
        list3.next.next = new ListNode(9);

        // Create a list of lists
        List<ListNode> listOfLists = new ArrayList<>();
        listOfLists.add(list1);
        listOfLists.add(list2);
        listOfLists.add(list3);
        MergeKSortedLists m = new MergeKSortedLists();
        // Merge the sorted linked lists
        ListNode mergedList = m.merge(listOfLists);

        // Print the merged list
        while (mergedList != null) {
            System.out.print(mergedList.value + " ");
            mergedList = mergedList.next;
        }
    }
}