class Solution {
    public int minDeletion(int[] nums) {
        var n = nums.length;
        var list = new ArrayList<Integer>();

        for (var num : nums)
            list.add(num);

        for (var i = 0; i < list.size();) {
            if (i % 2 == 0) {
                var curr = list.get(i);
                i++;

                while (i < list.size() && curr.equals(list.get(i))) {
                    list.remove(i);
                }
            } else
                i++;
        }

        if (list.size() % 2 == 1)
            list.removeLast();

        return n - list.size();
    }
}