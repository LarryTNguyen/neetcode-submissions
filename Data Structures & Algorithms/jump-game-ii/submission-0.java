/**
Since it there is always a valid answer, why wont we start from 0 and from the range 
n+1 -> n+1+nums[i], we take the biggest value and go from there?

test cases:
1 2 5 0 0 --> 4

1 2 5 3 0 0 0 0 --> 4 check to see if it will take a 3 even though it can just jump to the 5th spot and be valid

1 2 4 2 0 0 1 0 --> case to take the 1 instead of the 2

pseudocode algorithm:
start at index 0
count = 0
every case has a valid solution 
while(start != nums.length-1)
    int maxReach = 0
    for(int i = nums[start]; i > 0; i--)
        currReach = start+ i + nums[i];
        maxReach = max (maxReach, currReach);
    }
    start += maxReach;
    count++
}
return count

*/
class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int furthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            // Furthest we could reach from anything
            // we've seen in the current range
            furthest = Math.max(furthest, i + nums[i]);

            // We've reached the end of our current jump's range
            if (i == currentEnd) {
                jumps++;
                currentEnd = furthest;
            }
        }

        return jumps;
    }
}