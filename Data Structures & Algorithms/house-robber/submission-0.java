/**
Initial thoughts:
I noticed how the first two houses we would always get the original amount
house #3 += house#1
house 4 decision:
    we couldve came from house 1 OR house 2, but not house 3. 
    the amt of money from house 4, would be max of house 1, house 2

5 houses
2, 9, 8, 3, 6

2, 9, 10, 12, 16

[]
*/

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        if(nums.length == 3) return Math.max(nums[0]+nums[2],nums[1]);
        int[] money = new int [nums.length];
        money[0] = nums[0]; 
        money[1] = nums[1]; 
        money[2] = nums[0] + nums[2];
        for(int i = 3; i< nums.length; i++){
            money[i] = nums[i] + Math.max(money[i-3], money[i-2]);
            // System.out.println(money[i]);
        }
        return Math.max(money[money.length-1], money[money.length-2]);
    }
}
