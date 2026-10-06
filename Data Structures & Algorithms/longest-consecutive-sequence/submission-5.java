class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int max = 1;
        HashSet<Integer> numsFound = new HashSet<>();
        for(int num : nums){
            numsFound.add(num);
        }
        for(int start: nums){
            if(numsFound.contains(start-1)) continue;
            else{
                int currMax = 1;
                while(numsFound.contains(start+1)){
                    start+=1;
                    currMax++;
                }
                max = Math.max(max, currMax);
            }
        }
        return max;
    }   
}
