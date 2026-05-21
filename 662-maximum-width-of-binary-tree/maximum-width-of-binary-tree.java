class Solution {

    private class Pair {
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public int breadthFirstSearch(TreeNode root) {
        if (root == null) return 0;

        List<List<Long>> levels = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 0));

        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            long minIndex = queue.peek().index;
            long first = 0, last = 0;

            List<Long> temp = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Pair cur = queue.poll();
                TreeNode node = cur.node;
                long idx = cur.index - minIndex;

                if (i == 0) first = idx;
                if (i == size - 1) last = idx;

                temp.add(idx);

                if (node.left != null)
                    queue.offer(new Pair(node.left, 2 * idx));

                if (node.right != null)
                    queue.offer(new Pair(node.right, 2 * idx + 1));
            }

            levels.add(temp);
            maxWidth = Math.max(maxWidth, (int)(last - first + 1));
        }

        return maxWidth;
    }

    public int widthOfBinaryTree(TreeNode root) {
        return breadthFirstSearch(root);
    }
}