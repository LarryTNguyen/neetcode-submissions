class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] prefix = new int[nums.length];
        int [] suffix = new int[nums.length];
        prefix[0] = 1;
        suffix[0] = 1;
        for(int i = 0; i<nums.length; i++){
            if(i!= nums.length-1){
                prefix[i+1] = prefix[i] * nums[i];
                suffix[i+1] = suffix[i] * nums[nums.length - 1 - i]; 
            }
        }
        for(int k = nums.length -1; k >= 0; k--){
            prefix[nums.length-1-k] = prefix[nums.length-1-k] * suffix[k];  
        }
        return prefix;
    }
}  
