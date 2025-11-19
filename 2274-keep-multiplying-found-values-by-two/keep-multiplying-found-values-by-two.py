class Solution:
    def findFinalValue(self, nums: List[int], original: int) -> int:
        the_set = set()

        for num in nums:
            the_set.add(num)

        while original in the_set:
            original *= 2

        return original
