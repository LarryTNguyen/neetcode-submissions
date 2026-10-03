class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int maxStreak = 1;
        HashSet<Integer> possibleMin = new HashSet<>();
        HashSet<Integer> vals = new HashSet<>();
        for(int num: nums){
            vals.add(num);
        }
        for(int num: vals){
            if(!vals.contains(num-1)) possibleMin.add(num);
        }
        for(int min : possibleMin){
            int currStreak = 1;
            while(vals.contains(min+1)){
                currStreak++;
                min++;
            }
            if(maxStreak<currStreak) maxStreak = currStreak;
        }
        return maxStreak;
    }
}
