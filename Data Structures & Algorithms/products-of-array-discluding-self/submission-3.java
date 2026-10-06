class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[]answer = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i==0){
                answer[i] = 1;
            }
            else{
                answer[i] = answer[i-1]*nums[i-1];
            }
        }
        int suffix = 1;
        for(int j = nums.length -1; j>=0; j--){
            answer[j] *= suffix;
            suffix*=nums[j];
        }
        return answer;
    }
}  

/**
1, 2, 4, 6
1, 1, 2, 8
48, 24, 12, 8

**/
