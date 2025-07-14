class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        var i = 0;
        var j = a.length() - 1;

        while (i < j && a.charAt(i) == b.charAt(j)) {
            i++;
            j--;
        }

        if (isPalindrome(a, i, j) || isPalindrome(b, i, j))
            return true;

        i = 0;
        j = a.length() - 1;

        while (i < j && b.charAt(i) == a.charAt(j)) {
            i++;
            j--;
        }

        return isPalindrome(a, i, j) || isPalindrome(b, i, j);
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }
}