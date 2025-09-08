class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);

        var reach = 0;

        for (var coin : coins) {
            if (coin <= reach + 1)
                reach += coin;
            else
                break;
        }

        return reach + 1;
    }
}