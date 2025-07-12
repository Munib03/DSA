class Solution {
public boolean canMakeSubsequence(String str1, String str2) {
  var arr1 = str1.toCharArray();
  var arr2 = str2.toCharArray();

  var i = 0;
  var j = 0;

  while (i < arr1.length && j < arr2.length) {
    var me = arr1[i];
    var ou = arr2[j];

    if (me != ou) {
      if (me == 'z')
        me = 'a';
      else
        me++;

      arr1[i] = me;

      if (arr1[i] == arr2[j]) {
        i++;
        j++;
      }
      else
        i++;
    }

    else {
      j++;
      i++;
    }
  }

  Arrays.sort(arr1);
  Arrays.sort(arr2);

  i = 0;
  j = 0;

  while (i < arr1.length && j < arr2.length) {
    var me = arr1[i];
    var ou = arr2[j];

    if (me == ou) {
      i++;
      j++;
    } else {
      i++;
    }
  }

  return j == arr2.length;
}
}