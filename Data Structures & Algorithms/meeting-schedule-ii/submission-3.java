/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() == 0) return 0;
        intervals.sort((a,b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> end = new PriorityQueue<>();
        int rooms = 1;
        end.offer(intervals.get(0).end);
        for(int i = 1; i < intervals.size(); i++){
            if(end.isEmpty()){
                end.offer(intervals.get(i).end);
                continue;
            }
            if(intervals.get(i).start < end.peek()){
                end.offer(intervals.get(i).end);
                rooms++;
            }
            else{
                if (intervals.get(i).start >= end.peek()) {
                    end.poll();
                }
                end.offer(intervals.get(i).end);
            }
        }
        return rooms;
    }
}
