import java.math.BigInteger;
import java.util.PriorityQueue;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<BigInteger> pq = new PriorityQueue<>();

        for (String num : nums) {
            var bg = new BigInteger(num);
            pq.offer(bg);

            if (pq.size() > k)
                pq.poll();
        }

        return pq.peek() + "";
    }

}
