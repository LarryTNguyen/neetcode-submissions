class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> values = new HashSet<>();
        int longestCount = 0;
        for (int num : nums){
            values.add(num);
        }
        for (int num : nums){
            if(!values.contains(num-1)){
                int currentCount = 1;
                int temp = num;
                while(values.contains(temp+1)){
                    currentCount++;
                    temp++;
                }
                if(currentCount > longestCount){
                    longestCount = currentCount;
                }
            }
        }
        return longestCount;
    }
}
