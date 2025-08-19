class Solution {
public String maximumTime(String time) {
  var sb = new StringBuilder();
  sb.append(time);

  for (var i = 0; i < time.length(); i++) {
    var curr = sb.charAt(i);

    if (curr == '?') {
      switch (i) {
        case 0 -> {
          if (sb.charAt(1) == '?')
            sb.setCharAt(i, '2');
          
          else {
            var me = Integer.parseInt(sb.charAt(1) + "");
            if (me >= 0 && me <= 3)
              sb.setCharAt(i, '2');
            else
              sb.setCharAt(i, '1');
          }
        }

        case 1 -> {
          var me = Integer.parseInt(sb.charAt(0) + "");

          if (me == 0)
            sb.setCharAt(i, '9');
          else if (me == 2)
            sb.setCharAt(i, '3');
          else
            sb.setCharAt(i, '9');
        }

        case 3 -> sb.setCharAt(i, '5');

        case 4 -> sb.setCharAt(i, '9');
      }
    }
  }

  return sb.toString();
}
}