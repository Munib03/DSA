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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = null;
        var current = head;
        var index = 1;

        var list = new ArrayList<Integer>();

        while (current != null) {
            if (prev != null && current.next != null) {
                if (current.val > prev.val && current.val > current.next.val) {
                        list.add(index);
                }
                else if (current.val < prev.val && current.val < current.next.val) {
                    list.add(index);
                }
            }

            prev = current;
            current = current.next;
            index++;
        }

        if (list.size() < 2)
            return new int[] { -1, -1};

        var min = Integer.MAX_VALUE;
        for (var i=0; i < list.size() - 1; i++) {
            min = Math.min(min, list.get(i + 1) - list.get(i));
        }
        var max = (list.getLast()) - (list.getFirst());   

        return new int[] { min, max };
    }
}