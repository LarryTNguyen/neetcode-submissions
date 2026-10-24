class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        fastSpeed = max(piles)
        left = 1
        right = fastSpeed -1
        while left <= right:
            mid = left + (right - left) // 2
            currSpeed = mid
            currHours = self.helper(currSpeed, piles)
            if currHours <= h:
                fastSpeed = min(fastSpeed, currSpeed)
                right = mid - 1
            else:
                left = mid + 1
        return fastSpeed


    def helper(self, speed: int, piles: List[int]) -> int:
        count = 0
        for pile in piles:
            count += (pile + speed - 1) // speed
        return count
