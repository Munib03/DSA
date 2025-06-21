import java.math.BigInteger;
import java.util.PriorityQueue;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>(
                (a, b) -> {
                    BigInteger A = new BigInteger(a);
                    BigInteger B = new BigInteger(b);
                    return A.compareTo(B);
                });

        for (String num : nums) {
            pq.offer(num);

            if (pq.size() > k)
                pq.poll();
        }

        return pq.peek();
    }

}
