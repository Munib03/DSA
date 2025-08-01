class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        if (queue.isEmpty())
            throw new IllegalStateException();

        var newQueue = new LinkedList<Integer>();

        while (queue.size() > 1)
            newQueue.offer(queue.poll());

        var peek = queue.poll();
        while (!newQueue.isEmpty())
            queue.offer(newQueue.poll());

        return peek;
    }

    public int top() {
        if (queue.isEmpty())
            throw new IllegalStateException();

        var newQueue = new LinkedList<Integer>();
        while (queue.size() > 1)
            newQueue.offer(queue.poll());

        var peek = queue.poll();
        while (!newQueue.isEmpty())
            queue.offer(newQueue.poll());

        queue.offer(peek);

        return peek;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}