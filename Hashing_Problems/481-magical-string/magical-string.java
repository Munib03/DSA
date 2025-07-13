class Solution {
    public int magicalString(int n) {
        if (n == 0)
            return 0;

        if (n <= 3)
            return 1;

        int[] magic = new int[n];
        magic[0] = 1;
        magic[1] = 2;
        magic[2] = 2;

        int countOnes = 1;
        int nextNum = 1;
        int i = 2;
        int end = 3;

        while (end < n) {
            int repeat = magic[i];
            i++;

            for (int j = 0; j < repeat && end < n; j++) {
                magic[end] = nextNum;
                if (nextNum == 1) {
                    countOnes++;
                }
                end++;
            }

            nextNum = (nextNum == 1) ? 2 : 1;
        }

        return countOnes;
    }

}