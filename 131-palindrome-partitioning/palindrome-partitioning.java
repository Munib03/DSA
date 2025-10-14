class Solution {
    public List<List<String>> partition(String s) {
        recursion(0, s, new ArrayList<>());

        return ansList;
    }

    private final List<List<String>> ansList = new ArrayList<>();

    private void recursion(int index, String s, List<String> list) {
        if (index == s.length()) {
            ansList.add(new ArrayList<>(list));
            return;
        }

        for (var i = index; i < s.length(); i++) {
            var isPalindrome = isPalindrome(s, index, i);

            if (isPalindrome) {
                list.add(s.substring(index, i + 1));
                recursion(i + 1, s, list);
                list.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }
}