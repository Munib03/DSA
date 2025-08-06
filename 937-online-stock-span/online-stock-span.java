class StockSpanner {
    private Stack<Pair<Integer, Integer>> stack;
    private int indexCount;

    public StockSpanner() {
        stack = new Stack<>();
        indexCount = -1;
    }

    public int next(int price) {
        indexCount++;

        while (!stack.isEmpty() && price >= stack.peek().value())
            stack.pop();

        var ans = (!stack.isEmpty()) ? indexCount - stack.peek().index() : indexCount - (-1);
        stack.push(new Pair<>(price, indexCount));

        return ans;
    }

    record Pair<F, S>(F value, S index) {
    }
}
