class Solution {
    public int minimumOperations(int[] nums) {
        var minOperation = 0;

        for (var num : nums)
            if (num % 3 != 0)
                minOperation += Math.min(minToLeft(num), minToRight(num));

        return minOperation;
    }

    public int minToLeft(int num) {
        var cnt = 0;

        while (num % 3 != 0) {
            num--;
            cnt++;
        }

        return cnt;
    }

    public int minToRight(int num) {
        var cnt = 0;

        while (num % 3 != 0) {
            num++;
            cnt++;
        }

        return cnt;
    }

}