class Solution {
    public List<Integer> partitionLabels(String s) {
        var n = s.length();

        int[] lastIndexes = new int[26];
        for (var i = 0; i < n; i++)
            lastIndexes[s.charAt(i) - 'a'] = i;

        var list = new ArrayList<Integer>();
        var left = 0;
        var right = 0;

        for (var i = 0; i < n; i++) {
            right = Math.max(right, lastIndexes[s.charAt(i) - 'a']);

            if (i == right) {
                list.add(right - left + 1);
                left = i + 1;
            }
        }

        return list;
    }
}