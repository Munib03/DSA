class Solution {
    public int largestInteger(int num) {
        var pq1 = new PriorityQueue<Integer>(Collections.reverseOrder());
        var pq2 = new PriorityQueue<Integer>(Collections.reverseOrder());

        var sb = new StringBuilder();
        sb.append(num);

        for (var i = 0; i < sb.length(); i++) {
            var me = Integer.parseInt(sb.charAt(i) + "");

            if (me % 2 == 0)
                pq1.offer(me);

            else
                pq2.offer(me);
        }

        for (var i = 0; i < sb.length(); i++) {
            var me = Integer.parseInt(sb.charAt(i) + "");

            if (me % 2 == 0) {
                if (!pq1.isEmpty()) {
                    sb.setCharAt(i, (pq1.remove() + "").charAt(0));
                }
            } else {
                if (!pq2.isEmpty()) {
                    sb.setCharAt(i, (pq2.remove() + "").charAt(0));
                }
            }
        }

        return Integer.parseInt(sb.toString());
    }
}