class Solution {
public List<List<String>> partition(String s) {
  backtrack(0, s, new ArrayList<>());

  return ansList;
}

private final List<List<String>> ansList = new ArrayList<>();
private void backtrack(int index, String s, List<String> list) {
  if (index == s.length()) {
    ansList.add(new ArrayList<>(list));
    return;
  }

  for (var i=index; i < s.length(); i++) {
    var str = s.substring(index, i + 1);

    if (isPalindrome(str)) {
      list.add(str);
      backtrack(i + 1, s, list);

      list.removeLast();
    }
  }
}

private boolean isPalindrome(String s) {
  var sb = new StringBuilder();

  sb.append(s);
  sb.reverse();

  return sb.toString().equals(s);
}
}