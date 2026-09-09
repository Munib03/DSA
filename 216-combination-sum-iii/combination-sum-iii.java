class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ansList = new ArrayList<>();

        backtrack(1, n, k, 0, new ArrayList<>(), ansList);

        return ansList;
    }

    private void backtrack(int num, int target, int k, int sum,
            List<Integer> list, List<List<Integer>> ansList) {
        if (list.size() == k && sum == target) {
            ansList.add(new ArrayList<>(list));
            return;
        }

        if (num >= 10 || sum > target)
            return;

        sum += num;
        list.add(num);
        backtrack(num + 1, target, k, sum, list, ansList);

        sum -= num;
        list.removeLast();
        backtrack(num + 1, target, k, sum, list, ansList);
    }
}