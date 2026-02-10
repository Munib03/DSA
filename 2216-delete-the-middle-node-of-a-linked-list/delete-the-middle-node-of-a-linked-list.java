/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        var beforeSlowPointer = head;
        var slowPointer = head;
        var fastPointer = head;
        var afterSlowPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            beforeSlowPointer = slowPointer;
            slowPointer = slowPointer.next;
            afterSlowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        slowPointer.next = null;
        beforeSlowPointer.next = afterSlowPointer;

        return head;
    }
}