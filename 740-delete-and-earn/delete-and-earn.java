class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int x : nums)
            max = Math.max(max, x);

        int[] points = new int[max + 1];
        for (int x : nums)
            points[x] += x;

        return pickNotPick(0, points, new HashMap<>());
    }

    private int pickNotPick(int i, int[] points, Map<Integer, Integer> memo) {
        if (i >= points.length)
            return 0;

        if (memo.containsKey(i))
            return memo.get(i);

        int pick = points[i] + pickNotPick(i + 2, points, memo);
        int notPick = pickNotPick(i + 1, points, memo);

        int ans = Math.max(pick, notPick);
        memo.put(i, ans);

        return ans;
    }

}