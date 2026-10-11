class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return helper(0, nums);
    }

    public List<List<Integer>> helper(int index, int[]nums){
        if(index == nums.length){
            List<List<Integer>> base = new ArrayList<>();
            List<Integer> empty = new ArrayList<>();
            base.add(empty);
            return base;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> perm = helper(index+1, nums);
        for(int i = 0; i<perm.size(); i++){
            for(int k = 0; k<perm.get(i).size()+1; k++){
                ArrayList<Integer> copy = new ArrayList<>(perm.get(i));
                copy.add(k, nums[index]);
                result.add(copy);
            }
        }
        return result;
    }
}
