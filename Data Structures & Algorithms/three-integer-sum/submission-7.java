class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-2; i++){
            while(i>0 && i<nums.length-2 && nums[i]== nums[i-1]){
                i++;
            }
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                if(nums[i] + nums[left] + nums[right] > 0) right--;
                else if (nums[i] + nums[left] + nums[right] < 0) left++;
                else{
                    List<Integer> adding = new ArrayList<>();
                    adding.add(nums[i]);
                    adding.add(nums[left]);
                    adding.add(nums[right]);
                    if(!result.contains(adding)) result.add(adding);
                    left++;
                }
            }
        }
        return result;
    }
}
