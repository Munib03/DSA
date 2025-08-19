class Solution {
    public String removeDigit(String number, char digit) {
        var n = number.length();

        var sb = new StringBuilder();
        sb.append(number);
        var lastIndexSeen = -1;

        for (var i = 0; i < n; i++) {
            var curr = sb.charAt(i);

            if (curr == digit) {
                if (i == n - 1)
                    return sb.substring(0, n - 1);

                lastIndexSeen = i;

                if (Integer.parseInt(sb.charAt(i + 1) + "") > Integer.parseInt(curr + "")) {
                    sb.deleteCharAt(i);
                    return sb.toString();
                }
            }
        }

        if (lastIndexSeen == -1)
            return sb.substring(0, n - 1);

        sb.deleteCharAt(lastIndexSeen);
        return sb.toString();
    }
}