class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int [] answer = new int [2];
        for(int i = 0; i < nums.length; i++){
            if(count.containsKey(nums[i])){
                answer[0] = count.get(nums[i]);
                answer[1] = i;
            }
            else{
                count.put(target - nums[i], i);
            }
        }
        return answer;
    }
}
