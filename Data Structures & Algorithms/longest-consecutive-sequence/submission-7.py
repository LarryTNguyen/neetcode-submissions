class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums) == 0: return 0
        storage = set(nums)
        currMax = 1
        for num in storage:
            count = 1
            if num - 1 not in storage:
                while num + 1 in storage:
                    num+=1
                    count+=1
            currMax = max(count, currMax)
        return currMax
            
        