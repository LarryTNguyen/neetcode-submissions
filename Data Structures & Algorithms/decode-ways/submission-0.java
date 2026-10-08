/**
Initial thoughts:
My mind automatically goes to backtracking as we can make two decisions per character:
take only this char OR take this and the one after:
    i think this decision should only be considered if we are currently on a 1 or 2

first solution: some sort of recursion where the base case relies on the current selection is valid or not
recursion can be a lot of functional calls so it might not be the most optimal in terms of space
we also have to look around if a matching is impossible like 1001 since it would either have 100 1 or 10 01. Every 0 needs to be accompanied by a 1 or 2 on the left.

test cases 1012, 1010, 1001, 612
1012 --> JAB or JL --> 2
1010 -- > JJ --> 1
1001 -> 0
612 -> FAC or FL 
626 -> FBF or FZ

make an array of s.length called count
start at the end and go backward
626
count=
2, 2, 1

maybe multiply throughout from the end to the front since. if there is a 0 that cant be used anywhere, we want to ensure that the first index of string = 0
count array of length s.length()
int index set at the second to last
if(char at index != 0)
    can increment count by 1
if char at index -1 is either a 1 or 2
    if a 2, make sure to check charat index <= 6 
    else we could add count by 1 again
then, multiply count[index] with count[index+1] (we will manually fill out the last index ourselves)
0's get accounted for as if char at index is 0, we see if the one to the left is a 1 or 2 to increment by 1. if not, then a 0 will remain and will affect the rest of the string; could return early if after all that work, count[index] == 0;
return count[0]
*/

class Solution {
    public int numDecodings(String s) {
        int[] ways = new int[s.length()+1];
        ways[s.length()] = 1;
        for(int i = s.length()-1; i >=0; i--){
            if(s.charAt(i) == '0'){
                ways[i] = 0;
            } 
            else{
                ways[i] += ways[i+1];
                if(i+1<s.length()){
                    int twoDigit = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
                    if(twoDigit <=26 && twoDigit>=10){
                        ways[i] += ways[i+2];
                    }
                }
                
            }
        }
        return ways[0];
    }
}
