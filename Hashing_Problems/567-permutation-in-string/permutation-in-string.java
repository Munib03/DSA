class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int[] s1arr = new int[26];
        for (int i = 0; i < s1.length(); i++)
            s1arr[s1.charAt(i) - 'a']++;

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] s2arr = new int[26];
            for (int j = 0; j < s1.length(); j++)
                s2arr[s2.charAt(i + j) - 'a']++;

            if (Arrays.equals(s1arr, s2arr))
                return true;
        }

        return false;
    }
}