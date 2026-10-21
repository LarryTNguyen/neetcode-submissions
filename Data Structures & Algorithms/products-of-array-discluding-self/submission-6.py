class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        answer = []
        answer.append(1)
        i = 1
        while i < len(nums):
            answer.append(answer[i-1] * nums[i-1])
            i+=1
        i = len(nums) -1
        while i >= 0:
            if i == len(nums) - 1:
                i-=1
                continue
            answer[i] = answer[i] * nums[i+1]
            nums[i] *= nums[i+1]
            i-=1
        return answer