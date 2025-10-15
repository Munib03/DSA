class Solution {
    public int maxLength(List<String> arr) {
        backtrack(0, arr, new StringBuilder());

        return max;
    }

    private int max = 0;

    private void backtrack(int index, List<String> arr, StringBuilder sb) {
        if (index >= arr.size()) {
            if (!sb.isEmpty()) {
                var set = new HashSet<Character>();
                for (var ch : sb.toString().toCharArray())
                    set.add(ch);

                if (set.size() == sb.length())
                    max = Math.max(max, sb.length());
            }

            return;
        }

        if (!sb.isEmpty()) {
            var set = new HashSet<Character>();
            for (var ch : sb.toString().toCharArray())
                set.add(ch);

            if (set.size() == sb.length())
                max = Math.max(max, sb.length());
            else
                return;
        }

        var len = sb.length();
        backtrack(index + 1, arr, sb.append(arr.get(index)));

        sb.delete(len, sb.length());
        backtrack(index + 1, arr, sb);
    }

}