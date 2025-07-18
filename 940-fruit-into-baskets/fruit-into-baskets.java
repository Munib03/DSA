class Solution {
    public int totalFruit(int[] fruits) {
        var n = fruits.length;

        var map = new HashMap<Integer, Integer>();
        var max = 0;

        var left = 0;
        var right = 0;

        while (right < n) {
            var ou = fruits[right];

            map.put(ou, map.getOrDefault(ou, 0) + 1);
            if (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);

                if (map.get(fruits[left]) == 0)
                    map.remove(fruits[left]);

                left++;
            }

            else
                max = Math.max(max, right - left + 1);

            right++;
        }

        return max;
    }
}