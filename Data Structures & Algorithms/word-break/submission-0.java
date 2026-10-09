/**
Initial thoughts:
Something really important to mention is that the entire string needs to be made up of word dict, no remainders left

Solution draft:
boolean[] visited = new boolean[s.length + 1]
set v[0] to be true;
for(int i = 1; i< s.length() + 1; i++){
    for(int j = 0; j<i; j++){
        if dp[j](valid starting point) AND wordDict contains substring(j,i) then visited[i] = true  break   
    }
}
return visited[s.length()];
*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] visited = new boolean[s.length() +1];
        visited[0] = true;
        for(int i = 1; i<=s.length(); i++){
            for(int j = 0; j<i; j++){
                if(visited[j] && wordDict.contains(s.substring(j,i))){
                    visited[i] = true;
                    break;
                }
            }
        }
        return visited[s.length()];
    }
}
