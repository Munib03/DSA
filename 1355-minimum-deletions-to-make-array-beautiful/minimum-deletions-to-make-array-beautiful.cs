public class Solution {
public int MinDeletion(int[] nums)
    {
        int n = nums.Length;
        List<int> list = new List<int>(nums);

        int i = 0;
        while (i < list.Count)
        {
            if (i % 2 == 0)
            {
                int curr = list[i];
                i++;

                while (i < list.Count && list[i] == curr)
                {
                    list.RemoveAt(i);
                }
            }
            else
            {
                i++;
            }
        }

        if (list.Count % 2 == 1)
        {
            list.RemoveAt(list.Count - 1);
        }

        return n - list.Count;
    }
}