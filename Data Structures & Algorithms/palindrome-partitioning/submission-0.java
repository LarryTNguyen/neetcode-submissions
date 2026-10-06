/**
General approach:
Use backtracking as a solution:
Notices that all of the string has to be in each entry of list<list>
global var all to hold all combinations
it would be nice to have a helper function:
helper(startIndex, currentPartition, List<string> storage of ss) (ss - substring)
helper logic:
    is return type void
    if (startIndex = og word length)
        all.add(new arraylist<>(storage))
        return
    if currPart > og word's length 
        return; to get out 
    
    else
        if ss(start, currPart) is a palindrome
            storage adds that ss
            recursive call helper(currPart, currPart+1, storage)
            storage.removeLast()
            recursive call helper(startIndex, currPart + 1, storage)
        else
            recursive call helper (startIndex, currPart+1, storage)
    
    partition{
        helper(0, 1, new ArrayList<String>())
        return all;
    }

    ex)1 "aab"

*/


class Solution {
    List<List<String>> all = new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(0,1,s,new ArrayList<String>());
        return all;
    }

    public void helper(int start, int curr, String word, List<String> storage){
        if(start == word.length()){
            all.add(new ArrayList<>(storage));
            return;
        }
        if(curr > word.length()) return;
        String possible = word.substring(start,curr);
        if(isPalindrome(possible)){
            storage.add(possible);
            helper(curr, curr+1, word, storage);
            storage.removeLast();
            helper(start, curr+1, word, storage);
        }
        else helper(start, curr+1, word, storage);
    }

    public boolean isPalindrome(String check){
        int left = 0;
        int right = check.length()-1;
        while(left<=right){
            if(check.charAt(left) != check.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
