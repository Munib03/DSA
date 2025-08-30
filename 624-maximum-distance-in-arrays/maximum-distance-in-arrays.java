class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        var m = arrays.size();

        var min = Integer.MAX_VALUE;
        var max = Integer.MIN_VALUE;

        var maxDiff = 0;

        for (var i = 0; i < m; i++) {
            var curr = arrays.get(i);

            if (i == 0) {
                min = curr.getFirst();
                max = curr.getLast();
            } else {
                var currMin = curr.getFirst();
                var currMax = curr.getLast();

                var diff1 = Math.abs(max - currMin);
                var diff2 = Math.abs(min - currMax);

                maxDiff = Math.max(maxDiff, Math.max(diff1, diff2));
                min = Math.min(min, currMin);
                max = Math.max(max, currMax);
            }
        }

        return maxDiff;
    }
}