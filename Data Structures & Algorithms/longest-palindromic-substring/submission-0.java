/**

*/

class Solution {
    public String longestPalindrome(String s) {
        String answer = "";
        //Odd length check
        for(int i =0; i < s.length(); i++){
            int left = i;
            int right = i;
            while(left >=0 && right < s.length()){
                if(s.charAt(left) == s.charAt(right)){
                    left--;
                    right++;
                }
                else{
                    break;
                }
            }
            left++;
            right--;
            if(answer.length() < right-left+1){
                answer = s.substring(left, right+1);
            }
            //even
            left = i;
            right = i+1;
            while(left >=0 && right < s.length()){
                if(s.charAt(left) == s.charAt(right)){
                    left--;
                    right++;
                }
                else{
                    break;
                }
            }
            left++;
            right--;
            if(answer.length() < right-left+1){
                answer = s.substring(left, right+1);
            }
        }
        return answer;
    }
}
