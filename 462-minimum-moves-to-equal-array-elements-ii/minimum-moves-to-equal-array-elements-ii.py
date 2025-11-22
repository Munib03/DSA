class Solution:
    def minMoves2(self, nums: List[int]) -> int:
        nums.sort()
        n = len(nums)

        cnt = 0

        mid_element = nums[n // 2]
        for num in nums:
            cnt += abs(num - mid_element)

        return cnt
