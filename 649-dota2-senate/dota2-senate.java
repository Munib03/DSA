class Solution {
    public String predictPartyVictory(String senate) {
        var n = senate.length();

        var rQueue = new LinkedList<Integer>();
        var dQueue = new LinkedList<Integer>();

        for (var i = 0; i < senate.length(); i++) {
            var curr = senate.charAt(i);

            if (curr == 'R')
                rQueue.add(i);

            else
                dQueue.add(i);
        }

        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            var radiant = rQueue.poll();
            var dire = dQueue.poll();

            if (radiant < dire)
                rQueue.add(radiant + n);
            else
                dQueue.add(dire + n);
        }

        if (rQueue.isEmpty())
            return "Dire";

        return "Radiant";
    }
}