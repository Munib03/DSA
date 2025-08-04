class Solution {
    public String removeDuplicates(String s, int k) {
        var stack = new Stack<Pair<Character, Integer>>();

        for (var ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().key == ch) {
                var top = stack.pop();
                stack.push(new Pair<>(ch, top.val() + 1));
            } else
                stack.push(new Pair<>(ch, 1));

            if (stack.peek().val() == k)
                stack.pop();
        }

        var sb = new StringBuilder();
        for (var sth : stack)
            sb.append((sth.key() + "").repeat(sth.val()));

        return sb.toString();
    }

    record Pair<K, V>(K key, V val) {
    }
}