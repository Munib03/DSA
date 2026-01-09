class Solution {

    private TreeNode answer;
    private int deepest;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        deepest = maxDepth(root);

        dfs(root, 1);
        return answer;
    }

    private int dfs(TreeNode root, int depth) {
        if (root == null)
            return 0;

        if (depth == deepest) {
            answer = root;
            return depth;
        }

        var left = dfs(root.left, depth + 1);
        var right = dfs(root.right, depth + 1);

        if (left == deepest && right == deepest)
            answer = root;

        return Math.max(left, right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
