class MinStack {
    private Stack<Pair<Integer, Integer>> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty())
            stack.push(new Pair<>(val, val));

        else {
            var min = Math.min(val, stack.peek().min());
            stack.push(new Pair<>(val, min));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value();
    }

    public int getMin() {
        return stack.peek().min();
    }

    record Pair<F, S>(F value, S min) {
    }
}