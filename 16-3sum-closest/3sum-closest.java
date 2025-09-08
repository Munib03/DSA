class Solution {
    public int threeSumClosest(int[] nums, int target) {
        var n = nums.length;

        Arrays.sort(nums);
        var closestToTarget = Integer.MAX_VALUE;
        var diff = Integer.MAX_VALUE;

        for (var i = 0; i < n; i++) {
            var currentElement = nums[i];

            var leftIndex = i + 1;
            var rightIndex = n - 1;

            while (leftIndex < rightIndex) {
                var leftIndexNum = nums[leftIndex];
                var rightIndexNum = nums[rightIndex];

                var sum = currentElement + leftIndexNum + rightIndexNum;
                if (sum == target)
                    return target;

                else if (sum < target)
                    leftIndex++;

                else
                    rightIndex--;

                var currDiff = Math.abs(sum - target);
                if (currDiff < diff) {
                    closestToTarget = sum;
                    diff = currDiff;
                }
            }
        }

        return closestToTarget;
    }

}