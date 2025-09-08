class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        var n = nums.length;

        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();

        for (var i = 0; i < n; i++) {
            var iElement = nums[i];

            for (var j = i + 1; j < n; j++) {

                var jElement = nums[j];
                var leftIndex = j + 1;
                var rightIndex = n - 1;

                while (leftIndex < rightIndex) {
                    var leftIndexNum = nums[leftIndex];
                    var rightIndexNum = nums[rightIndex];

                    var sum = (long) iElement + jElement + leftIndexNum + rightIndexNum;
                    if (sum == target) {
                        var list = new ArrayList<Integer>();
                        list.add(iElement);
                        list.add(jElement);
                        list.add(leftIndexNum);
                        list.add(rightIndexNum);

                        ans.add(list);

                        leftIndex++;
                        rightIndex--;
                    }

                    else if (sum < target)
                        leftIndex++;
                    else
                        rightIndex--;
                }
            }
        }

        return new ArrayList<>(ans);
    }

}