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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null)
            return null;

        var size = 0;
        var current = head;

        while (current != null) {
            size++;
            current = current.next;
        }

        var removedNodeIndex = size - n;
        var cnt = 0;

        if (removedNodeIndex == 0)
            head = head.next;

        else {
            current = head;
            var beforeTargetNode = head;
            var afterTargetNode = head;

            while (cnt != removedNodeIndex && current != null) {
                beforeTargetNode = current;
                current = current.next;
                afterTargetNode = current.next;

                cnt++;
            }

            beforeTargetNode.next = afterTargetNode;
        }

        return head;
    }
}