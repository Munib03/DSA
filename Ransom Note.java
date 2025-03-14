public boolean canConstruct(String ransomNote, String magazine) {
  if (magazine.length() < ransomNote.length())
    return false;
  
  int[] freq = new int[26];

  for (var ch: magazine.toCharArray())
    freq[ch - 'a']++;
  
  for (var ch: ransomNote.toCharArray()) {
    freq[ch - 'a']--;

    if (freq[ch - 'a'] < 0)
      return false;
  }

  return true;
}
