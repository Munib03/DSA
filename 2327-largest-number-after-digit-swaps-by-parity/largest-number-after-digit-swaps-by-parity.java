class Solution {
    public int largestInteger(int num) {
        var oddPQ = new PriorityQueue<Integer>();
        var evenPQ = new PriorityQueue<Integer>();

        var copyNum = num;
        while (copyNum > 0) {
            var nowNum = copyNum % 10;

            if (nowNum % 2 == 0)
                evenPQ.offer(nowNum);
            else
                oddPQ.offer(nowNum);

            copyNum /= 10;
        }

        copyNum = num;
        var sb = new StringBuilder();

        while (copyNum > 0) {
            var nowNum = copyNum % 10;

            if (nowNum % 2 == 0)
                sb.insert(0, evenPQ.poll());
            else
                sb.insert(0, oddPQ.poll());

            copyNum /= 10;
        }

        return Integer.parseInt(sb.toString());
    }
}