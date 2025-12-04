class Solution {
    public int minMirrorPairDistance(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        var theAns = Integer.MAX_VALUE;

        for (var i = 0; i < nums.length; i++) {
            var num = nums[i];

            if (map.containsKey(num))
                theAns = Math.min(theAns, i - map.get(num));

            map.put(reverseNum(num), i);
        }

        return (theAns == Integer.MAX_VALUE) ? -1 : theAns;
    }

    private int reverseNum(int num) {
        var sb = new StringBuilder();
        sb.append(num);
        sb.reverse();

        return Integer.parseInt(sb.toString());
    }
}