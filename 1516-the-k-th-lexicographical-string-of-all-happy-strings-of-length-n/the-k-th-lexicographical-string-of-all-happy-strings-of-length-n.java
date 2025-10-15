class Solution {
    public String getHappyString(int n, int k) {
        generate(n, new StringBuilder());

        return k <= list.size() ? list.get(k - 1) : "";
    }

    private final List<String> list = new ArrayList<>();

    private void generate(int n, StringBuilder sb) {
        if (sb.length() == n) {
            list.add(sb.toString());
            return;
        }

        for (var c : new char[] { 'a', 'b', 'c' }) {
            if (sb.isEmpty() || sb.charAt(sb.length() - 1) != c) {
                sb.append(c);
                generate(n, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}