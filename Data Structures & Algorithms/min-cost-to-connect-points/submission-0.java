/**
Something I noticed:
The points can come from anywhere. Tha main thing I am thinking about is performing dijkstras through setting the min heap to be based on the lowest manhattan distance 

heap where we compare a,b math.abs (a0 - b0) + (a1 - b1)
shortestPath hs <int[]> to keep track of where we have been so far
int sum = 0

heap offers [0], 0
    maybe we could then fill up the heap with the distance from all points to the first
(the heap will be empty eventually so maybe our condition could be until hm size isnt points.length)
while shortestPAth size isnt points.length:
    current = heap poll
    if shortestPath doesnt have coord yet:
        hs put coord
        sum += distance 
        iterate through all points and see which isnt in shortestPath yet:
            add all points and distance from current coord into heap

return sum
*/

class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> 
            {return Integer.compare(a[1], b[1]);}
        );
        HashSet<Integer> visited = new HashSet<>();
        minHeap.offer(new int[] {0, 0});
        int sum = 0;
        for(int i = 1; i<points.length; i++){
            int mDist = manDist(points[0], points[i]);
            minHeap.offer(new int[]{i,mDist});
        }
        while(visited.size() != points.length){
            int[] current = minHeap.poll();
            if(visited.add(current[0])){
                sum+= current[1];
                for(int i = 0; i<points.length; i++){
                    if(visited.contains(i)) continue;
                    else{
                        int mDist = manDist(points[current[0]], points[i]);
                        minHeap.offer(new int[]{i, mDist});
                    }
                }
            }
        }
        return sum;
    }

    public int manDist(int[] a, int[]b){
        int xDist = Math.abs(a[0] - b[0]);
        int yDist = Math.abs(a[1] - b[1]);
        return xDist + yDist;
    }
}
