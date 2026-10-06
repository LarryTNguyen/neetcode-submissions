class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int windowSize = 0;
        int left = 0;
        int answer = 0;
        char[] word = s.toCharArray();
        for(int right = 0; right < s.length(); right++){
            int charIndex = s.charAt(right) - 'A';
            freq[charIndex]++;
            windowSize++;
            maxFreq = Math.max(maxFreq, freq[charIndex]);
            while(windowSize - maxFreq>k){
                freq[s.charAt(left)-'A']--;
                left++;
                windowSize--;
            }
            answer = Math.max(answer,windowSize);
        }
        return answer;
    }
}
