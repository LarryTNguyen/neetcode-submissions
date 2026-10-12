/**
Heap solution:
have a heap only containing k elements
iterate through array, using a hashmap to count freq
go through each key, and add onto min heap if heap size != k || freq > heap peek 
heap of int[] where [freq, num]
afterward, make an int[] sized k and poll all elements inside heap
something to keep note, there could be multiple nums that share the same freq, take that into account 
when offering into heap

return int[]sized k
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) ->{
            return Integer.compare(a[0], b[0]);
        });
        HashMap<Integer, Integer> freqCount = new HashMap<>();
        for(int num: nums){
            freqCount.putIfAbsent(num, 0);
            freqCount.put(num, freqCount.get(num) +1);
        }
        // going through all unique vals in nums and putting the highest freq in heap
        for(int key: freqCount.keySet()){
            if(heap.size() != k || freqCount.get(key) >= heap.peek()[0]){
                if(heap.size() == k) heap.poll();
                heap.offer(new int[]{freqCount.get(key), key});
            }
        }
        int[] answer = new int[k];
        for(int i = 0; i <answer.length; i++){
            int[] curr = heap.poll();
            answer[i] = curr[1];
        }
        return answer;
    }
}
