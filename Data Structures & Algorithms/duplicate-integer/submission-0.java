class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> dupes = new HashSet<>();
        for(int num : nums){
            if(!dupes.add(num)) return true;
        }
        return false;
    }
}