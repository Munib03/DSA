class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        var n = arr.length;

        Arrays.sort(arr);
        arr[0] = 1;

        var left = 0;
        var right = 1;

        while (right < n) {
            var me = arr[left];
            var ou = arr[right];

            var diff = Math.abs(me - ou);
            if (diff > 1)
                arr[right] = me + 1;

            left++;
            right++;
        }

        return arr[n - 1];
    }
}