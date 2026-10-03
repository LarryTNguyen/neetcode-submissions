class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indices = new HashMap<>();
        int[] answer = new int [2];
        for(int i = 0; i < nums.length; i++){
            if(indices.containsKey(target-nums[i])){
                answer[0] = indices.get(target-nums[i]);
                answer[1] = i;
            }
            else{
              indices.put(nums[i], i);
            } 
        }
        return answer;
    }
}
