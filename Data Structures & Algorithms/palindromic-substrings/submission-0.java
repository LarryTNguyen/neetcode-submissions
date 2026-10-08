/**
Initial thoughts:
we could do the palindrome check per character, counting all the times we could increase?
do both even and odd lengths

test cases:
abc --> a, b, c -> 3
aaa --> a, aa, a, aaa, aa, a -> 6
baab -->b, a, aa, baab, a, b -> 6

algorithm:
count at 0 and will increment per expansion
for loop through each char of s with int i 
per character, do an odd length expansion and even length expansion
    int left at currIndex 
    int right at currIndex
    oddLength expansion where left >=0 and right < string length
        if charAt left is same as charAt right
            increment count
            expand left and right -1 and +1 respectively
        else charAt left and right arent same
            break out of the loop immediately
    set left as i and right as i+1
    even length expansion with the same conditions

return count
*/
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i<s.length(); i++){
            int left = i;
            int right = i;
            while(left>=0 && right < s.length()){
                if(s.charAt(left) == s.charAt(right)){
                    count++;
                    left--;
                    right++;
                }
                else break;
            }
            left = i;
            right = i+1;
            while(left>=0 && right<s.length()){
                if(s.charAt(left) == s.charAt(right)){
                    count++;
                    left--;
                    right++;
                }
                else break;
            }
        }
        return count;
    }
}
