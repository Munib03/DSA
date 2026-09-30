class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        var n = seq.length();
        int[] ans = new int[n];
        var index = 0;

        var cnt1 = 0;
        var cnt2 = 0;

        for (var ch : seq.toCharArray()) {
            if (ch == '(') {
                if (cnt1 == 0 || cnt1 < cnt2) {
                    cnt1++;
                    ans[index++] = 0;
                } else {
                    cnt2++;
                    ans[index++] = 1;
                }
            } else if (ch == ')') {
                if (cnt1 > 0) {
                    cnt1--;
                    ans[index++] = 0;
                } else if (cnt2 > 0) {
                    cnt2--;
                    ans[index++] = 1;
                }
            }
        }

        return ans;
    }
}