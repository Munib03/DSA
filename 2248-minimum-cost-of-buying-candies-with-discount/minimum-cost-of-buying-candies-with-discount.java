class Solution {
public int minimumCost(int[] cost) {
  var n = cost.length;

  Arrays.sort(cost);
  var totalSum = 0;

  for (var num: cost)
    totalSum += num;

  var cnt = 2;
  for (var i = n - 1; i >= 0; i--) {
    if (cnt == 0) {
      cnt = 2;
      totalSum -= cost[i];
      continue;
    }

    cnt--;
  }

  return totalSum;
}
}