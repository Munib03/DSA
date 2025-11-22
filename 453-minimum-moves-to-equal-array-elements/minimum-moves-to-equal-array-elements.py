class Solution:
    def minMoves(self, nums: List[int]) -> int:
        min_val = float("inf")
        for num in nums:
            min_val = min(num, min_val)

        cnt = 0
        for num in nums:
            cnt += abs(num - min_val)

        return cnt
