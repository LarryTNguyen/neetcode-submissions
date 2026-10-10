/**
Initial thoughts: I am currently thinking about implementing a min heap of size k
In order to add onto the heap, you would have to be bigger than the top of the heap
Would implement this in an array of size k+1
0th index will be -1

constructor logic:
initialize heap array and set i of 0 to be -1 (dummy node);
fill up array using heapify logic

int add(val)
if val <= top of heap return top of heap
if val > top of heap; add val into array using heap logic 
return heap[1];
*/

class KthLargest {
    PriorityQueue<Integer> heap;
    int max;
    public KthLargest(int k, int[] nums) {
        heap= new PriorityQueue<>();
        max = k;
        for(int num: nums){
            add(num);
        }
    }
    
    public int add(int val) {
        if(heap.size() < max){
            heap.offer(val);
        }
        else{
            if(val <= heap.peek()) return heap.peek();
            else{
                heap.offer(val);
                heap.poll();
            }
        }
        return heap.peek();
    }
}
