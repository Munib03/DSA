class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        cnt = 0

        for num in nums:
            rem = num % 3
            cnt += min(rem, 3 - rem)

        return cnt