/**
I am currently thinking about using a max heap of size k to store int[][] in which they rep x,y coordinates. 
if heap size less than k, heap adds in coord
if heap is of size k, 
    calculate euclidean distance of current coord
    if dist of curr is greater than or equal to the peek coord, dont add
    if it is smaller, poll and then offer(curr)
once done iterating, can add all of the coords in the heap into [][];

thinking about creating a helper fn called find dist in which it returns a double 
edge cases:
[[0,2], [2,0], [2,2]] k = 2 --> 0,2 and 2,0

[[1,2], [2,0], [2,2]] k = 1 --> 2,0
is it possible to have more than k coords with the same distance?
*/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            long distA = calcDist(a[0],a[1]);
            long distB = calcDist(b[0],b[1]);

            return Long.compare(distB, distA);
        });
        for(int []coord:points){
            if(heap.size() < k){
                heap.offer(coord);
            } 
            else{
                long distCurr = calcDist(coord[0],coord[1]);
                long distPeek = calcDist(heap.peek()[0],heap.peek()[1]);
                if(distPeek > distCurr){
                    heap.poll();
                    heap.offer(coord);
                }
            }
        }
        int[][] answer = new int[k][2];
        while(heap.size() > 0){
            answer[heap.size()-1] = heap.poll();
        }
        return answer;
    }

    public long calcDist(int x, int y){
        long squareX = (long) x*x;
        long squareY = (long) y*y;
        return squareX + squareY;
    }
}
