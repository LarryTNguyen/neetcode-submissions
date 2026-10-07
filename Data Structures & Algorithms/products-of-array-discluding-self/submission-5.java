class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int [nums.length];
        for(int i = 0; i < answer.length; i++){
            if(i==0)answer[i] = 1;
            else{
                answer[i] = answer[i-1] * nums[i-1];
            }
        }
        
        for(int j = answer.length-1; j >=0; j--){
            if(j == answer.length-1) continue;
            else{
                answer[j] = answer[j] * nums[j+1];
                nums[j] *= nums[j+1];
            }
        }
        return answer;
    }
}  

/**
1, 2, 24, 6
1, 1, 2, 8
48, 24, 12, 8

**/
