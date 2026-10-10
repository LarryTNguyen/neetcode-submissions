/**
So I noticed that we could merge intervals if the one interval's start time is >= prev interval start and <= prev interval end 

edge cases: 

[1,3] [4,6] new = [2,5] --> 1,6 case of double stacking

[1 2] [3 5] [9 10]; new= [6 7] --> 1,2; 3,5; 6,7; 9,10 case of adding it somewhere else 

[1 2] [3 5] [8 10]; new = [6 9] --> 1 2; 3 5; 6 10 case of adding the end to an interval

we know that the empty case of interval length is possible --> return new interval
maybe could use heap somehow?

pseudocode algorithm:

for each interval in intervals:
    check if newStart OR newEnd is within bounds of interval
    if no -> continue 
    if yes -> logic to merge the two:
        if newStart and newEnd within bounds: break;
        else if only newStart: interval's end = newEnd then break 
        else only newEnd: interval's start = start then break 

another loop to encapsulate any lingering merge to be 

right now, it doesn't deal with the test case of no merges
*/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) return new int[][]{newInterval};
        List<int[]> answer = new ArrayList<>();
        for(int i = 0; i<intervals.length; i++){
            if(intervals[i][0] > newInterval[1]){
                answer.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    answer.add(intervals[j]);
                }
                return answer.toArray(new int[answer.size()][]);
            }
            else if(intervals[i][1] < newInterval[0]){
                answer.add(intervals[i]);
            }
            else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }
        answer.add(newInterval);
        
        return answer.toArray(new int[answer.size()][]);
    }
}
