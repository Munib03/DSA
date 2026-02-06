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
    public boolean isPalindrome(ListNode head) {
        var sb = new StringBuilder();

        var current = head;
        while (current != null) {
            sb.append(current.val);
            current =  current.next;
        }

        return sb.toString().equals(sb.reverse().toString());
    }
}