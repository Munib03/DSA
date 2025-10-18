class Solution {
    public int countCompleteSubarrays(int[] nums) {
        var set = new HashSet<Integer>();
        for (var num : nums)
            set.add(num);

        var size = set.size();

        var cnt = 0;

        for (var i = 0; i < nums.length; i++) {
            var tempSet = new HashSet<Integer>();

            for (var j = i; j < nums.length; j++) {
                tempSet.add(nums[j]);

                if (tempSet.size() == size)
                    cnt++;
            }
        }

        return cnt;
    }
}