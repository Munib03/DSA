class Solution {
    public boolean isValid(String s) {
        var sb = new StringBuilder();
        sb.append(s);

        while (sb.toString().contains("abc")) {
            var index = sb.indexOf("abc");
            sb.delete(index, 3 + index);
        }

        return sb.isEmpty();
    }
}