/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxProduct(TreeNode root) {
        var mod = 1_000_000_007;
        var list = new ArrayList<Long>();

        getTotalSum(root, list);

        var totalSum = list.getLast();
        var maxAns = 0L;

        for (var sth : list) {
            var tempSum = (totalSum - sth) * sth;
            maxAns = Math.max(maxAns, tempSum);
        }

        return (int) (maxAns % mod);
    }

    private long getTotalSum(TreeNode root, List<Long> list) {
        if (root == null)
            return 0;

        var left = getTotalSum(root.left, list);
        var right = getTotalSum(root.right, list);

        var currSubTreeSum = left + right + root.val;
        list.add(currSubTreeSum);

        return currSubTreeSum;
    }
}