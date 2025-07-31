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
            var min = Math.min(val, stack.peek().getSecond());
            var pair = new Pair<>(val, min);

            stack.push(pair);
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().getFirst();
    }

    public int getMin() {
        return stack.peek().getSecond();
    }
}

class Pair<F, S> {
    private final F first;
    private final S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }
}
