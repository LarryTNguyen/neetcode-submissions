class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i< stones.length; i++){
            max.offer(stones[i]);
        }
        while(max.size()>1){
            int stone1 = max.poll();
            int stone2 = max.poll();
            if(stone1 != stone2){
                int remaining = Math.abs(stone1 - stone2);
                max.offer(remaining);
            }
        }
        if(max.size() == 0) return 0;
        return max.poll();
    }
}
