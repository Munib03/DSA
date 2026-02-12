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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        var list = new ArrayList<Integer>();
        var current = head;

        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        Collections.sort(list);

        var newHead = new ListNode(list.getFirst());
        var tail = newHead;

        for (var i=1; i < list.size(); i++) {
            tail.next = new ListNode(list.get(i));
            tail = tail.next;
        }

        return newHead;
    }
}