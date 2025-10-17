class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        var n = nums1.length;

        var map = addToMap(nums2);
        var nge = nextGreaterElement(nums2);
        int[] ans = new int[n];

        for (var i = 0; i < n; i++) {
            var index = map.get(nums1[i]);
            ans[i] = nge[index];
        }

        return ans;
    }

    private int[] nextGreaterElement(int[] nums) {
        var n = nums.length;

        var stack = new Stack<Integer>();
        int[] ans = new int[n];

        for (var i = n - 1; i >= 0; i--) {
            var currNum = nums[i];

            while (!stack.isEmpty() && currNum >= stack.peek())
                stack.pop();

            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(currNum);
        }

        return ans;
    }

    private Map<Integer, Integer> addToMap(int[] nums) {
        var map = new HashMap<Integer, Integer>();

        for (var i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        return map;
    }
}