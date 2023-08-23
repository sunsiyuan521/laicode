package Kway;
import PublicClass.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.List;
public class MergeKSortedLists {
    public ListNode merge(List<ListNode> listOfLists) {
        // Create a priority queue to hold the nodes from all the lists
        // The queue will be sorted based on the values of the nodes
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(11, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.value == o2.value) {
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });
        // Create a dummy node to start the merged list
        ListNode dummy = new ListNode(0);
        // Keep a reference to the last node in the merged list
        ListNode cur = dummy;
        // Add all the nodes from the input lists to the priority queue
        for(ListNode node : listOfLists) {
            if(node != null) {
                minHeap.offer(node);
            }
        }
        // Merge the nodes in the priority queue
        while(!minHeap.isEmpty()) {
            // Take the node with the smallest value from the queue
            cur.next = minHeap.poll();
            if(cur.next.next != null) {
                // Add the next node from the same list to the queue
                minHeap.offer(cur.next.next);
            }
            // Move to the next node in the merged list
            cur = cur.next;
        }
        // Return the merged list starting from the dummy node's next reference
        return dummy.next;
    }
}
