class StockSpanner {
    List<Integer> previousDays;

    public StockSpanner() {
        previousDays = new ArrayList<>();
    }

    public int next(int price) {
        previousDays.add(price);

        var cnt = 0;

        for (var i = previousDays.size() - 1; i >= 0; i--) {
            var curr = previousDays.get(i);

            if (curr > price)
                break;

            cnt++;
        }

        return cnt;
    }
}