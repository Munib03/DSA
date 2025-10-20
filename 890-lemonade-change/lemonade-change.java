class Solution {
    public boolean lemonadeChange(int[] bills) {
        var fives = 0;
        var tens = 0;

        for (var bill : bills) {
            if (bill == 5)
                fives++;

            else if (bill == 10) {
                if (fives <= 0)
                    return false;

                tens++;
                fives--;
            } else {
                if (tens >= 1 && fives >= 1) {
                    tens--;
                    fives--;
                } else if (fives >= 3)
                    fives -= 3;

                else
                    return false;
            }
        }

        return true;
    }
}