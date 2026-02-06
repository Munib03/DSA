/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        var slowPointer = head;
        var fastPointer = head;
        var flag = false;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;

            if (slowPointer == fastPointer) {
                flag = true;
                break;
            }
        }   

        if (flag) {
            slowPointer = head;

            while (slowPointer != fastPointer) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }

            return slowPointer;
        }

        return null;
    }
}