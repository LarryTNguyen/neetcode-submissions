class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            while(left<right){
                if(nums[left] + nums[right] == target){
                    List<Integer> adding = new ArrayList<>(List.of(nums[left], nums[i], nums[right]));
                    if(!result.contains(adding)) result.add(adding);
                    right--;
                    left++;
                }
                else if (nums[left] + nums[right] > target){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return result;
    }
}
