class Solution:
    def minLengthAfterRemovals(self, s: str) -> int:
        a_count = s.count("a")
        b_count = s.count("b")

        return abs(a_count - b_count)
