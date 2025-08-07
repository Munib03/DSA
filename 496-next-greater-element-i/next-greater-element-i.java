class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        var n = nums1.length;

        int[] ans = new int[n];
        var map = addToMap(nums2);
        var nge = nextGreaterElement(nums2);

        for (var i = 0; i < n; i++) {
            var index = map.get(nums1[i]);
            ans[i] = nge[index];
        }

        return ans;
    }

    private int[] nextGreaterElement(int[] nums) {
        var n = nums.length;

        int[] ans = new int[n];
        var monotonicStack = new Stack<Integer>();

        for (var i = n - 1; i >= 0; i--) {
            var num = nums[i];

            while (!monotonicStack.isEmpty() && num >= monotonicStack.peek())
                monotonicStack.pop();

            ans[i] = (monotonicStack.isEmpty()) ? -1 : monotonicStack.peek();
            monotonicStack.push(num);
        }

        return ans;
    }

    private HashMap<Integer, Integer> addToMap(int[] nums) {
        var map = new HashMap<Integer, Integer>();

        for (var i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        return map;
    }
}