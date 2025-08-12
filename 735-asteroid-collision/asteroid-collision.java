class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        var n = asteroids.length;

        var stack = new Stack<Integer>();

        for (var i = 0; i < n; i++) {
            var num = asteroids[i];

            if (num > 0)
                stack.push(num);

            else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(num))
                    stack.pop();

                if (!stack.isEmpty() && stack.peek() == Math.abs(num))
                    stack.pop();

                else if (stack.isEmpty() || stack.peek() < 0)
                    stack.push(num);
            }
        }

        int[] ans = new int[stack.size()];
        for (var i = 0; i < stack.size(); i++)
            ans[i] = stack.get(i);

        return ans;
    }
}