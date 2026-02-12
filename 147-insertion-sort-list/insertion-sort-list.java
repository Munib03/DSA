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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        var middNode = midOfLL(head);

        var rightHalf = middNode.next;
        middNode.next = null;

        var leftSorted = insertionSortList(head);
        var rightSorted = insertionSortList(rightHalf);

        return merge(leftSorted, rightSorted);
    }

    private ListNode midOfLL(ListNode head) {
        var slow = head;
        var fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode merge(ListNode left, ListNode right) {
        var dummy = new ListNode(0);
        var tail = dummy;

        while (left != null && right != null) {
            var val1 = left.val;
            var val2 = right.val;

            if (val1 <= val2) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }

            tail = tail.next;
        }

        if (left != null)
            tail.next = left;

        else if (right != null)
            tail.next = right;

        return dummy.next;
    }
}