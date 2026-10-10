/**
Initial thoughts:

I think i could just do min heap of size k
if heap size < k, offer
else check to see if nums[i] > heap.peek 
    if yes -> offer nums[i] and poll to remove peek
    else -> do nothing
return peek

test case:

[6,9,1,8] k = 4 --> 1
[6,9,1,8] k = 2 --> 8
[9,9,2] k = 2 --> 9

6, 9, 1, 8

heap
9 9
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num:nums){
            if(heap.size() < k) heap.offer(num);
            else{
                if(num > heap.peek()){
                    heap.offer(num);
                    heap.poll();
                }
            }
        }
        return heap.peek();
    }
}
