import java.util.*;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int[] nums, List<Integer> path, List<List<Integer>> res) {
        // save current subset (copy!)
        res.add(new ArrayList<>(path));

        // try choices from `start` onward
        for (int i = start; i < nums.length; i++) {
            // choose
            path.add(nums[i]);

            // recurse (i+1 because each element can be used once)
            backtrack(i + 1, nums, path, res);

            // undo (backtrack)
            path.remove(path.size() - 1);
        }
    }

    // optional: quick test
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subsets(new int[] { 1, 2, 3 }));
    }
}
