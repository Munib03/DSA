class Solution {
    public int smallestNumber(int n) {
        var i = n;
        while (i < 10001) {
            var num = toBinary(i);
            var flag = true;

            for (var sth : num.toCharArray()) {
                if (sth == '0') {
                    flag = false;
                    break;
                }
            }

            if (flag)
                return i;

            i++;
        }

        return -1;
    }

    private String toBinary(int n) {
        return Integer.toBinaryString(n);
    }
}