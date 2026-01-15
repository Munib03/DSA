class Solution {
public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
  Arrays.sort(hBars);
  Arrays.sort(vBars);

  var hMax = 1;
  var vMax = 1;

  var hCurr = 1;
  var vCurr = 1;

  for (var i=1; i < hBars.length; i++) {
    var prev = hBars[i - 1];
    var curr = hBars[i];

    if (Math.abs(prev - curr) == 1)
      hCurr++;
    else
      hCurr = 1;

    hMax = Math.max(hMax, hCurr);
  }

  for (var i=1; i < vBars.length; i++) {
    var prev = vBars[i - 1];
    var curr = vBars[i];

    if (Math.abs(prev - curr) == 1)
      vCurr++;
    else
      vCurr = 1;

    vMax = Math.max(vMax, vCurr);
  }

  var minSide = Math.min(hMax, vMax) + 1;

  return minSide * minSide;
}
}