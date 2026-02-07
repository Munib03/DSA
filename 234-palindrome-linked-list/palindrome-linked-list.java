class Solution {
    public boolean isPalindrome(ListNode head) {
        var stack = new Stack<Integer>();

        var current = head;
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }

        current = head;
        while (!stack.isEmpty()) {
            var top = stack.pop();
            var val = current.val;

            if (top != val)
                return false;

            current = current.next;
        }

        return true;
    }
}