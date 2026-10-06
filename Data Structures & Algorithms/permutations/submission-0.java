class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return helper(0,nums);
    }

    public List<List<Integer>> helper(int index, int[] nums){
        if(index == nums.length){
            List<List<Integer>> returnable = new ArrayList<>();
            returnable.add(new ArrayList<>());
            return returnable;
        }

        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> perm = helper(index + 1, nums);

        for(int i = 0; i<perm.size(); i++){
            for(int j = 0; j < perm.get(i).size()+1; j++){
                ArrayList<Integer> copy = new ArrayList<>(perm.get(i));
                copy.add(j, nums[index]);
                result.add(copy);
            }
        }
        return result;
    }
}
