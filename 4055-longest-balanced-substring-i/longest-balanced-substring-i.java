class Solution {
    public int longestBalanced(String s) {
        var n = s.length();

        var max = 0;
        int[] freq = new int[27];

        for (var i = 0; i < n; i++) {
            Arrays.fill(freq, 0);

            for (var j = i; j < n; j++) {
                var flag = true;

                var c = s.charAt(j) - 'a';
                freq[c]++;

                for (var x : freq) {
                    if (x > 0 && x != freq[c]) {
                        flag = false;
                        break;
                    }
                }

                if (flag)
                    max = Math.max(max, j - i + 1);

            }
        }

        return max;
    }

}