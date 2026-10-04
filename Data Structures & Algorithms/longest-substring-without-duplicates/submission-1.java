class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        String str = "";
        for(int i = 0; i<s.length(); i++){
            if(str.indexOf(s.charAt(i)) == -1){
                str += s.charAt(i);
            }
            else{
                maxLength = Math.max(maxLength, str.length());
                left += str.indexOf(s.charAt(i)) + 1;
                str = s.substring(left,i+1);
            }
        }
        maxLength = Math.max(maxLength, str.length());
        return maxLength;
    }
}
