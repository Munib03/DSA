class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int t = nums.get(i);

            if ((t & 1) == 0) {
                ans[i] = -1;
                continue;
            }

            int k = 0;
            int temp = t;
            while ((temp & 1) == 1) {
                k++;
                temp >>= 1;
            }

            ans[i] = t - (1 << (k - 1));
        }

        return ans;
    }
}
