class Solution {
public int minimumDeletions(int[] nums) {
  var n = nums.length;

  var minIndex = 0;
  var maxIndex = 0;

  for (var i=0; i < n; i++) {
    var num = nums[i];

    if (num < nums[minIndex])
      minIndex = i;

    if (num > nums[maxIndex])
      maxIndex = i;
  }

  // [1, 2, -4, 123, 10]
  var removeBothFromFront = Math.max(minIndex, maxIndex) + 1;
  var removeBothFromEnd = n -Math.min(minIndex, maxIndex);

  var removeMaxFromFront = maxIndex + 1;
  var removeMaxFromEnd = n - maxIndex;

  var removeMinFromFront = minIndex + 1;
  var removeMinFromEnd = n - minIndex;

  var min1 = Math.min(removeMinFromFront, removeMinFromEnd);
  var min2 = Math.min(removeMaxFromEnd, removeMaxFromFront);

  var min3 = min1 + min2;
  var min4 = Math.min(removeBothFromEnd, removeBothFromFront);

  return Math.min(min3, min4);
}
}