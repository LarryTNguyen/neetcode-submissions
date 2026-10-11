class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //heap to store node # and suggested path to take
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) ->{
            return Integer.compare(a[1], b[1]);
        });
        //Hashmap to store the shortest path 
        HashMap<Integer, Integer> shortestPath = new HashMap<>();
        heap.offer(new int[] {k, 0});
        while(!heap.isEmpty()){
            int[] current = heap.poll();
            if(!shortestPath.containsKey(current[0])){
                shortestPath.putIfAbsent(current[0], current[1]);
                if(shortestPath.get(current[0]) > current[1]){
                    shortestPath.put(current[0], current[1]);
                }
                for(int i = 0; i<times.length; i++){
                    if(times[i][0] == current[0]){
                        heap.offer(new int[]{times[i][1], times[i][2] +       current[1]});
                    }
                }
            }
        }
        // System.out.println(shortestPath.size());
        if(shortestPath.size() != n) return -1;
        int sum = 0;
        for(int key: shortestPath.keySet()){
            sum = Math.max(sum, shortestPath.get(key));
        }   
        return sum;
    }
}
