class Solution {
    public int repeatedNTimes(int[] nums) {
        var set = new HashSet<Integer>();

        for (var num : nums) {
            if (set.contains(num))
                return num;

            set.add(num);
        }

        return -1;
    }

}