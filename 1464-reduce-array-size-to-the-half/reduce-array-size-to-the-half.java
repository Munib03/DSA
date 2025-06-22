class Solution {
    public int minSetSize(int[] arr) {
        var n = arr.length;

        var map = new HashMap<Integer, Integer>();

        for (var num : arr)
            map.put(num, map.getOrDefault(num, 0) + 1);

        map = sortMapByValueDescending(map);

        var copy = n;
        var cnt = 0;
        for (var entry : map.entrySet()) {
            var val = entry.getValue();

            copy -= val;
            cnt++;

            if (copy <= n / 2)
                break;
        }

        return cnt;
    }

    public LinkedHashMap<Integer, Integer> sortMapByValueDescending(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        // Sort by value in descending order
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

}