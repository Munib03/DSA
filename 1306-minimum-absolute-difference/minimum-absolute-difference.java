class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        var n = arr.length;

        Arrays.sort(arr);

        List<List<Integer>> ansList = new ArrayList<>();
        var minDiff = Math.abs(arr[1] - arr[0]);
        for (var i = 0; i < n - 1; i++)
            minDiff = Math.min(minDiff, Math.abs(arr[i] - arr[i + 1]));

        for (var i = 0; i < n; i++) {
            var me = arr[i];
            var list = new ArrayList<Integer>();

            for (var j = i + 1; j < n; j++) {
                var ou = arr[j];
                var diff = ou - me;

                if (diff == minDiff) {
                    list.add(me);
                    list.add(ou);

                    ansList.add(list);
                } else {
                    break;
                }
            }
        }

        return ansList;
    }

}