class Solution {
    public int[][] kClosest(int[][] points, int k) {
        var map = new TreeMap<Double, List<List<Integer>>>();

        var x1 = 0;
        var y1 = 0;

        for (var point : points) {
            var x2 = point[0];
            var y2 = point[1];

            List<List<Integer>> ans = new ArrayList<>();
            double diff = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
            var list = new ArrayList<Integer>();

            list.add(x2);
            list.add(y2);

            ans.add(list);

            if (map.containsKey(diff))
                map.get(diff).add(list);
            else
                map.put(diff, ans);
        }

        var i = 0;
        int[][] ans = new int[k][2];
        for (List<List<Integer>> val : map.values()) {
            for (var sth : val) {
                int[] temp = new int[2];
                temp[0] = sth.getFirst();
                temp[1] = sth.get(1);

                ans[i++] = temp;
                k--;

                if (k <= 0)
                    break;
            }

            if (k <= 0)
                break;
        }

        return ans;
    }
}