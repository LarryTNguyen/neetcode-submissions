class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        sumCount = {}
        for i in range(len(nums)):
            if target - nums[i] in sumCount:
                return [sumCount[target - nums[i]], i]
            else:
                sumCount[nums[i]] = i
        return []