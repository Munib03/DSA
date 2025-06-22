class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        var map = new TreeMap<Double, int[]>();

        for (var i = 0; i < arr.length; i++) {
            double me = arr[i];

            for (var j = i + 1; j < arr.length; j++) {
                var ou = arr[j];

                double fraction = me / ou;
                map.put(fraction, new int[] { arr[i], arr[j] });
            }
        }

        var cnt = 0;

        for (var val : map.values()) {
            cnt++;

            if (cnt == k)
                return val;
        }

        return new int[] {};
    }

}