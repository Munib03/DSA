class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        var left = height(root.left);
        var right = height(root.right);

        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }
}