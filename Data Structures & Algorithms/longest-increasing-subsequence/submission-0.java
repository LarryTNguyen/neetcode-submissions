/**
Initial thoughts:

I was thinking of a solution where we have an array for dp where each index holds how many numbers before index in nums 
for example:
9 1 4 2 3 3 7
0 1 2 2 3 3 4

at nums[1], it checks at previous indices to see if 1) if nums[i] is bigger than any previous num[index] bc if so, then we can just put dp[i] = dp[index] + 1 OR if a num[index] is bigger and has a 1 in dp[index]. 

when we are at nums[2], we know that 4 is bigger than 1 so we could just take dp[1] and increment it 1

at nums[3], 2 is smaller than 4 so it goes nums[1] and sees 1 and takes its dp rather than 4's dp 

I am a bit concerned for run time i think as what if it was something like 

[0, 3, 3, ... 1]
where the longest increasing subsequence is 0,1 but it is filled with 3's 
*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] longestSeq = new int[nums.length];
        int max = 1;
        Arrays.fill(longestSeq, 1);
        for(int i = 1; i < nums.length; i++){
            for(int k = i-1; k >= 0; k--){
                if(nums[k] < nums[i]){
                    longestSeq[i] = Math.max(longestSeq[i],longestSeq[k] +1);
                    max = Math.max(max, longestSeq[i]);
                }
            }
        }
        return max;
    }
}
