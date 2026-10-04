class Solution {
    public int characterReplacement(String s, int k) {
        int[] freqCount = new int[26];
        int maxFreq = 0;
        int answer = 1;
        char[] sArr = s.toCharArray();
        int left = 0;
        for(int i = 0; i<sArr.length; i++){
            int index = sArr[i] - 'A';
            freqCount[index]++;
            maxFreq = Math.max(maxFreq, freqCount[index]);
            int windowSize = i - left + 1;
            while(windowSize - maxFreq > k){
                int removed = sArr[left] - 'A';
                freqCount[removed]--;
                windowSize--;
                left++;
            }
            answer = Math.max(answer, windowSize);
        }
        return answer;
    }
}
