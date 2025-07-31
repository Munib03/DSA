class MinStack {
    private final Stack<Pair<Integer, Integer>> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            var pair = new Pair<>(val, val);
            stack.push(pair);
        } else {
            var min = Math.min(val, stack.peek().second());
            var pair = new Pair<>(val, min);

            stack.push(pair);
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().first();
    }

    public int getMin() {
        return stack.peek().second();
    }
}

record Pair<F, S>(F first, S second) {}