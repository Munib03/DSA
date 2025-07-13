class Solution {
    public boolean checkInclusion(String s1, String s2) {
        var n = s1.length();
        var m = s2.length();

        var arr = s1.toCharArray();
        Arrays.sort(arr);
        s1 = new String(arr);

        var i = 0;
        var j = n - 1;

        while (j < m) {
            var ss = s2.substring(i, j + 1).toCharArray();
            Arrays.sort(ss);

            var newString = new String(ss);

            if (s1.contains(newString))
                return true;

            i++;
            j++;
        }

        return false;
    }
}