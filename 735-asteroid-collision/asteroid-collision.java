class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        var n = asteroids.length;

        var stack = new Stack<Integer>();

        for (var asteroid : asteroids) {
            if (asteroid > 0)
                stack.push(asteroid);

            else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid))
                    stack.pop();

                if (!stack.isEmpty() && stack.peek() == Math.abs(asteroid))
                    stack.pop();

                else if (stack.isEmpty() || stack.peek() < 0)
                    stack.push(asteroid);
            }
        }

        var index = 0;
        int[] ans = new int[stack.size()];
        for (var num : stack)
            ans[index++] = num;

        return ans;
    }
}