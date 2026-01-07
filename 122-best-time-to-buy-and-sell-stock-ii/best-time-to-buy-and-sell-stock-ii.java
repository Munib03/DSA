class Solution {
public int maxProfit(int[] prices) {
  var n = prices.length;
  
  int[][] memo = new int[n][2];
  for (var sth: memo)
    Arrays.fill(sth, -1);
  
  return buyNotBuy(0, 1, prices, memo);
}

private int buyNotBuy(int day, int canBuy, int[] prices, int[][] memo) {
  if (day == prices.length)
    return 0;

  else if (memo[day][canBuy] != -1)
    return memo[day][canBuy];
  
  var profit = 0;
  if (canBuy == 1) {
    var buy = -prices[day] + buyNotBuy(day + 1, 0, prices, memo);
    var skip = buyNotBuy(day + 1, 1, prices, memo);

    profit = Math.max(buy, skip);
  } else {
    var sell = prices[day] + buyNotBuy(day + 1, 1, prices, memo);
    var skip = buyNotBuy(day + 1, 0, prices, memo);

    profit = Math.max(sell, skip);
  }

  memo[day][canBuy] = profit;
  
  return profit;
}

}