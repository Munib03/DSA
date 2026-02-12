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
        if (list1 == null && list2 == null)
            return null;
        else if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;

        var temp1 = list1;
        var temp2 = list2;

        var nums = new ArrayList<Integer>();

        while (temp1 != null) {
            nums.add(temp1.val);
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            nums.add(temp2.val);
            temp2 = temp2.next;
        }

        Collections.sort(nums);

        ListNode head = new ListNode(nums.getFirst());
        var tempHead = head;

        for (var i = 1; i < nums.size(); i++) {
            head.next = new ListNode(nums.get(i));
            head = head.next;
        }

        return tempHead;
    }
}