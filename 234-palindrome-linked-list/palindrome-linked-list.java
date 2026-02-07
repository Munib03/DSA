class Solution {
    public boolean isPalindrome(ListNode head) {
        var mid = midOfLL(head);
        var headOfNewLL = reverseLinkedList(mid);

        var left = head;
        var right = headOfNewLL;

        while (right != null) {
            var val1 = left.val;
            var val2 = right.val;

            if (val1 != val2)
                return false;

            left = left.next;
            right = right.next;
        }

        return true;
    }

    private ListNode midOfLL(ListNode head) {
        var slowPointer = head;
        var fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }

    private ListNode reverseLinkedList(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;

        while (curr != null) {
            var next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }
}