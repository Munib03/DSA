class Solution {
    public int minimumOperations(int[] nums) {
        var sum = 0;

        for (var num : nums) {
            var rem = num % 3;
            sum += Math.min(rem, 3 - rem);
        }   

        return sum;
    }
}