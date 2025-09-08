class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        var n = nums.length;

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (var i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            var iElement = nums[i];

            for (var j = i + 1; j < n; j++) {
                if (j > (i + 1) && nums[j] == nums[j - 1])
                    continue;

                var jElement = nums[j];
                var leftIndex = j + 1;
                var rightIndex = n - 1;

                while (leftIndex < rightIndex) {
                    var leftIndexNum = nums[leftIndex];
                    var rightIndexNum = nums[rightIndex];

                    long sum = (long) iElement + jElement + leftIndexNum + rightIndexNum;
                    if (sum == target) {
                        var list = new ArrayList<Integer>();
                        list.add(iElement);
                        list.add(jElement);
                        list.add(leftIndexNum);
                        list.add(rightIndexNum);

                        ans.add(list);

                        leftIndex++;
                        rightIndex--;

                        while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex - 1])
                            leftIndex++;

                        while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex + 1])
                            rightIndex--;
                    }

                    else if (sum < target)
                        leftIndex++;
                    else
                        rightIndex--;
                }
            }
        }

        return ans;
    }
}