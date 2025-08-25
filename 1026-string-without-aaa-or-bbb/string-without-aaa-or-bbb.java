class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder res = new StringBuilder();

        while (a > 0 || b > 0) {
            int len = res.length();

            if (len >= 2 && res.charAt(len - 1) == res.charAt(len - 2)) {
                if (res.charAt(len - 1) == 'a') {
                    res.append('b');
                    b--;
                } else {
                    res.append('a');
                    a--;
                }
            } else {
                if (a >= b) {
                    res.append('a');
                    a--;
                } else {
                    res.append('b');
                    b--;
                }
            }
        }

        return res.toString();
    }

}