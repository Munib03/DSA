class Solution {
    public int minMirrorPairDistance(int[] nums) {
        var map = new HashMap<Integer, Integer>();

        var n = nums.length;
        var res = Integer.MAX_VALUE;

        for (var i = 0; i < n; i++) {
            var num = nums[i];

            if (map.containsKey(num)) {
                res = Math.min(res, i - map.get(num));
            }

            map.put(reverse(num), i);
        }

        return (res < Integer.MAX_VALUE) ? res : -1;
    }

    private int reverse(int a) {
        var b = 0;

        while (a > 0) {
            b = b * 10 + a % 10;
            a /= 10;
        }

        return b;
    }

}