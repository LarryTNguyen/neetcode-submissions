/**
Initial thoughts:
since this is in the heaps section, i do know that heaps will be used in the answer at some point 

max heap holds int, 
Q holds the [remaining, ready count]
timeElapsed set at 0

create a freq array from the char tasks
once done, scan through freq array and add [num[index] , 0] into heap
once scan is done -> start going through max heap

while Q isn't empty
heap poll[remaining--, timeElapsed + n] 
Q adds onto that (only if remaining -1 > 0)
if(q peek()[1] == timeElapsed]) bring back to heap
timeElapsed++

return time elapsed
*/


/**
A A A B C n=3
Heap: 0 
Q: 
Time: 10 
*/
class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> taskExe = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> wait = new ArrayDeque<>();
        int[] alphaFreq = new int [26];
        int timeElapsed= 0;
        for(char c: tasks){
            alphaFreq[c-'A']++;
        }
        for(int freq: alphaFreq){
            if(freq!=0){
                taskExe.offer(freq);
            }
        }
        while(taskExe.size()!=0||!wait.isEmpty()){
            if(!wait.isEmpty() && wait.peek()[1] <= timeElapsed){
                taskExe.offer(wait.poll()[0]);
            }
            if(taskExe.size()!=0){
                int remainingCount = taskExe.poll() -1;
                if(remainingCount > 0){
                    wait.offer(new int[] {remainingCount, timeElapsed+n+1});
                }
            }
            timeElapsed++;
        }
        return timeElapsed;
    }
}






