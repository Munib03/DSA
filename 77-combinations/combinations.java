class Solution {
    public List<List<Integer>> combine(int n, int k) {
        rec(n, k, 1, new ArrayList<>());

        return new ArrayList<>(ansList);
    }

    private final Set<List<Integer>> ansList = new HashSet<>();

    private void rec(int n, int k, int index, List<Integer> list) {
        if (list.size() == k) {
            var temp = new ArrayList<>(list);
            Collections.sort(temp);

            ansList.add(temp);
            return;
        }

        for (var i = index; i <= n; i++) {
            list.add(i);
            rec(n, k, i + 1, list);
            list.removeLast();
        }
    }
}