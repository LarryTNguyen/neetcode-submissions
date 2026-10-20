class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        storage = set()
        for num in nums:
            if num in storage:
                return True
            else:
                storage.add(num)
        return False