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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        var p1 = list1;
        var p2 = list2;

        var newHead = new ListNode(0);
        var temp = newHead;

        while (p1 != null && p2 != null) {
            var val1 = p1.val;
            var val2 = p2.val;

            if (val1 <= val2) {
                temp.next = p1;
                p1 = p1.next;
            }
            else {
                temp.next = p2;
                p2 = p2.next;
            }

            temp = temp.next;
        }

        if (p1 != null)
            temp.next = p1;
        else if (p2 != null)
            temp.next = p2;

        return newHead.next;
    }
}