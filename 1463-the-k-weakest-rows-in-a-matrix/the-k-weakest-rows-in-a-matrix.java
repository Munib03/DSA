class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;

        var map = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1)
                    cnt++;
            }
            map.put(i, cnt);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue()))
                return a.getValue() - b.getValue();
            return a.getKey() - b.getKey();
        });

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i).getKey();
        }

        return ans;
    }
}