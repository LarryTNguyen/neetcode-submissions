class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> dupes = new HashSet<>();
        int max = 0;
        int left = 0;
        for(int right = 0; right<s.length(); right++){
            while(dupes.contains(s.charAt(right))){
                dupes.remove(s.charAt(left));
                left++;
            }
            dupes.add(s.charAt(right));
            max = Math.max(max, right-left+1);
        }
        return Math.max(max, s.length()-left);
    }
}
