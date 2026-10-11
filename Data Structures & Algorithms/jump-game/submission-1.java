/**
Am thinking:
1) start at the end
2) go backwards the list until you find an index that could reach the end 
3) set the end as that index and keep repeating. 
4) if we could reach the end before __, return true
5) if we exit out the loop, we return false 

end = nums.length - 1
for(int i= end; i >= 0; i--)
    scan down the array to find an index that can jump here;
    if found, set i to that index
    if i breaks out the loop, return false 
    if i finds a path before breaking out the loop, return true

1 2 1 0 1 --> false

1 2 0 1 0 --> true 

3 0 0 4 0 0 --> true

3 0 4 0 0 0 --> true 

*/
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        int end = nums.length-1;
        for(int i = end-1; i >= 0; i--){
            if(i + nums[i] >= end){
                end = i;
                if(end == 0) return true;
            }
        }
        return false;
    }
}
