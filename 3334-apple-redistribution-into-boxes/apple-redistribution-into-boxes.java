class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        var n = apple.length;
        var m = capacity.length;

        Arrays.sort(apple);
        Arrays.sort(capacity);

        var cnt = 0;

        var left = n - 1;
        var right = m - 1;

        while (left >= 0 && right >= 0) {
            var me = apple[left];
            var ou = capacity[right];

            if (ou == me) {
                left--;
                right--;

                cnt++;
            }

            else if (ou > me) {
                apple[left] = 0;
                capacity[right] -= me;
                left--;

                if (capacity[right] == 0)
                    cnt++;

                if (left < 0)
                    cnt++;
            }

            else {
                capacity[right] = 0;
                apple[left] -= ou;

                if (capacity[right] == 0)
                    cnt++;

                right--;
            }
        }

        return cnt;
    }
}