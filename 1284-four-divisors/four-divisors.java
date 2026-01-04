class Solution {
    public int sumFourDivisors(int[] nums) {
        var sum = 0;

        for (var num : nums) {
            var cnt = 0;
            var list = new ArrayList<Integer>();

            for (var i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    cnt++;
                    list.add(i);

                    if (i != num / i) {
                        cnt++;
                        list.add(num / i);
                    }
                }
            }
            if (cnt == 4) {
                for (var n : list)
                    sum += n;
            }

        }

        return sum;
    }
}