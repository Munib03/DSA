class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            var sum = 0;
            var count = 0;

            for (int num : nums) {
                if (sum + num <= queries[i]) {
                    sum += num;
                    count++;
                } else
                    break;
            }

            res[i] = count;
        }

        return res;
    }
}