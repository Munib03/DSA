class Solution {
    public int largestInteger(int num) {
        var sb = new StringBuilder();
        sb.append(num);

        for (var i = 0; i < sb.length(); i++) {
            var me = Integer.parseInt(sb.charAt(i) + "");
            var he = 0;
            var index = 0;

            for (var j = i + 1; j < sb.length(); j++) {
                var ou = Integer.parseInt(sb.charAt(j) + "");

                if (me % 2 == 0 && ou % 2 == 0 && ou > he) {
                    he = ou;
                    index = j;
                }

                else if (me % 2 == 1 && ou % 2 == 1 && ou > he) {
                    he = ou;
                    index = j;
                }
            }

            if (he > me) {
                sb.setCharAt(i, (he + "").charAt(0));
                sb.setCharAt(index, (me + "").charAt(0));
            }
        }

        return Integer.parseInt(sb.toString());
    }

}