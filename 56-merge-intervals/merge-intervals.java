class Solution {
    public int[][] merge(int[][] intervals) {
        var n = intervals.length;

        Arrays.sort(intervals, Comparator.comparingInt(key -> key[0]));
        List<List<Integer>> ansList = new ArrayList<>();

        var temp = new ArrayList<Integer>();
        temp.add(intervals[0][0]);
        temp.add(intervals[0][1]);

        ansList.add(temp);

        for (var i = 1; i < n; i++) {
            var lastElementInAnsList = ansList.getLast().getLast();
            var startElementOfCurrentArr = intervals[i][0];

            if (lastElementInAnsList >= startElementOfCurrentArr) {
                if (lastElementInAnsList < intervals[i][1])
                    ansList.getLast().set(1, intervals[i][1]);
            } else {
                var temp1 = new ArrayList<Integer>();
                temp1.add(intervals[i][0]);
                temp1.add(intervals[i][1]);

                ansList.add(temp1);
            }
        }

        int[][] ansMatrix = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) {
            ansMatrix[i][0] = ansList.get(i).get(0);
            ansMatrix[i][1] = ansList.get(i).get(1);
        }

        return ansMatrix;
    }
}