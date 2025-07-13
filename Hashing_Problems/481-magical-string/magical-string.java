class Solution {
    public int magicalString(int n) {
        if (n == 0)
            return 0;
        if (n <= 3)
            return 1;

        var list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(2);

        int nextNum = 1;
        int i = 2;
        int oneCount = 1;

        while (list.size() < n) {
            int repeat = list.get(i++);
            for (int j = 0; j < repeat && list.size() < n; j++) {
                list.add(nextNum);
                if (nextNum == 1) {
                    oneCount++;
                }
            }
            nextNum = (nextNum == 1) ? 2 : 1;
        }

        return oneCount;
    }
}