/**
Observations:
answer in any order --> rule out permutations
need to have all numbers and the diff letters attatched to the number
could have string array to match numbers w what string of letters it will have
backtracking (i only know bc it was the topic)
has to return the list of strings
branch off each letter we get to: no "decisions" on whether to include or exclude
seems like base case for our helper is if we reached the end of the string corresponding to the digit or not
add into our global list if the string is the same length as digits
also a global array that has the digits mapped to the letters that correspond to it 

helper returns void
digits "34"
helper(0, "")
    check to see if digitIndex == digits.length
        if yes, all adds in curr
        return to get out;
    String currLetters from digitLetters[digitIndex]
    for(int i = 0; i < currLetters.length(); i++){
        curr adds in the currLetters.charAt(i)
        recursive call helper(digitIndex+1, curr, digits)
        curr removes the recently added in letter
    }
helper(int digitIndex, String curr, String digits){
        if(digits.length() == 0) return all
    }
*/

class Solution {
    List<String> all = new ArrayList<>();
    String[] digitLetters = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return all;
        helper(0, "", digits);
        return all;
    }

    public void helper(int digitIndex, String curr, String digits){
        if(digitIndex == digits.length()){
            all.add(curr);
            return;
        }
        String currLetters = digitLetters[digits.charAt(digitIndex)-'0' -2];
        for(int i = 0; i < currLetters.length(); i++){
            helper(digitIndex+1, curr+currLetters.charAt(i), digits);
        }
    }
}
