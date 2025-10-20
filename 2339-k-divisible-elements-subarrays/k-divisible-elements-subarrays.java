class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        var allSubArrays = generateAllSubArrays(nums);
        Set<List<Integer>> set = new HashSet<>();

        var cnt = 0;

        for (var num : allSubArrays) {
            var divisors = 0;

            for (var sth : num) {
                if (sth % p == 0)
                    divisors++;
            }

            if (divisors <= k && !set.contains(num))
                cnt++;

            set.add(num);
        }

        return cnt;
    }

    private List<List<Integer>> generateAllSubArrays(int[] nums) {
        var n = nums.length;

        List<List<Integer>> ansList = new ArrayList<>();

        for (var i = 0; i < n; i++) {
            var tempList = new ArrayList<Integer>();

            for (var j = i; j < n; j++) {
                tempList.add(nums[j]);
                ansList.add(new ArrayList<>(tempList));
            }
        }

        return ansList;
    }
}