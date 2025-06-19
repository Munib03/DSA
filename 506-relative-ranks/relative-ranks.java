class Solution {
    void main() {

    }

    public String[] findRelativeRanks(int[] score) {
        var n = score.length;
        var pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (var num : score)
            pq.offer(num);

        var i = 1;
        var map = new HashMap<Integer, Integer>();
        while (!pq.isEmpty()) {
            map.put(pq.remove(), i++);
        }

        String[] ans = new String[n];
        for (var f = 0; f < n; f++) {
            var num = score[f];
            var rank = map.get(num);

            if (rank == 1)
                ans[f] = "Gold Medal";

            else if (rank == 2)
                ans[f] = "Silver Medal";

            else if (rank == 3)
                ans[f] = "Bronze Medal";

            else
                ans[f] = "" + rank;
        }

        return ans;
    }
}