class Solution {
    public void rotate(int[] nums, int k) {
        var n = nums.length;

        var remRotations = 0;
        if (k > n) {
            remRotations = k - n;
            k = n;
        }

        doRotation(nums, k);

        while (remRotations > 0) {
            if (remRotations < k)
                k = remRotations;

            doRotation(nums, k);

            remRotations -= k;
        }
    }

    private void doRotation(int[] nums, int k) {
        var n = nums.length;
        var list = new ArrayList<Integer>();

        for (var i = n - k; i < n; i++)
            list.add(nums[i]);

        for (var i = 0; i < (n - k); i++)
            list.add(nums[i]);

        for (var i = 0; i < n; i++)
            nums[i] = list.get(i);
    }
}