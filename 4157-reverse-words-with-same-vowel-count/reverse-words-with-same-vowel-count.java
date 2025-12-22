class Solution {
    public String reverseWords(String s) {
        var words = s.split(" ");

        var theFirstWordVowels = countVowels(words[0]);
        var sb = new StringBuilder();
        sb.append(words[0]).append(" ");

        for (var i = 1; i < words.length; i++) {
            var word = words[i];

            if (countVowels(word) == theFirstWordVowels) {
                var temp = new StringBuilder();
                temp.append(word);
                temp.reverse();

                sb.append(temp);
            } else
                sb.append(word);

            sb.append(" ");
        }

        return sb.toString().trim();
    }

    private int countVowels(String s) {
        var cnt = 0;

        for (var ch : s.toCharArray())
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                cnt++;

        return cnt;
    }

}