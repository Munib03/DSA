class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ansList = new ArrayList<>();

        backtrack(1, n, k, 0, new ArrayList<>(), ansList);

        return ansList;
    }

    private void backtrack(int num, int n, int k, int sum,
            List<Integer> list, List<List<Integer>> ansList) {

        if (sum > n || list.size() > k || num >= 10) {
            if (sum == n && list.size() == k) {
                ansList.add(new ArrayList<>(list));
            }

            return;
        }

        sum += num;
        list.add(num);
        backtrack(num + 1, n, k, sum, list, ansList);

        sum -= num;
        list.removeLast();
        backtrack(num + 1, n, k, sum, list, ansList);
    }
}