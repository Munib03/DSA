class Solution {
    public String maximumOddBinaryNumber(String s) {
        var ones = 0;
        var zeros = 0;

        for (var ch : s.toCharArray()) {
            if (ch == '1')
                ones++;
            else
                zeros++;
        }

        var sb = new StringBuilder();
        while (ones > 1) {
            sb.append(1);
            ones--;
        }

        while (zeros-- > 0)
            sb.append(0);

        sb.append(1);

        return sb.toString();
    }
}