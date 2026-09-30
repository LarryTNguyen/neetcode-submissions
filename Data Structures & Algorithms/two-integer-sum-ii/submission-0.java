class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(numbers[left] + numbers[right] != target){
            // System.out.println("Left bound is : " + numbers[left] + ". Right number is: " + numbers[right]);
            if(numbers[left] + numbers[right] > target){
                right--;
            }
            else left++;
        }
        return new int[]{++left,++right};
    }
}
