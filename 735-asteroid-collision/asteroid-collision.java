class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        var n = asteroids.length;

        var stack = new Stack<Integer>();

        for (var i = 0; i < n; i++) {
            var currNum = asteroids[i];

            if (currNum > 0)
                stack.push(currNum);

            else {
                while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(currNum) > stack.peek())
                    stack.pop();

                if (!stack.isEmpty() && stack.peek() == Math.abs(currNum))
                    stack.pop();

                else if (stack.isEmpty() || stack.peek() < 0)
                    stack.push(currNum);
            }
        }

        int[] ans = new int[stack.size()];
        for (var i = 0; i < ans.length; i++)
            ans[i] = stack.get(i);

        return ans;

    }
}