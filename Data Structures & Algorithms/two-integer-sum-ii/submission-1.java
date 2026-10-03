class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int k = numbers.length - 1;
        while(numbers[i] + numbers[k] != target){
            if(numbers[i] + numbers[k] > target){
                k--;
            }
            else i++;
        }
        return new int[]{++i,++k};
    }
}
