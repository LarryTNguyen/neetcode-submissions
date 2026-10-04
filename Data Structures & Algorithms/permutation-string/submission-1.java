class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for(Character c: s1.toCharArray()){
            int index = c-'a';
            s1Count[index]++;
        }
        for(int right = 0; right < s2.length(); right++){
            s2Count[s2.charAt(right) - 'a']++;
            if (right >= s1.length()) {
                s2Count[s2.charAt(right - s1.length()) - 'a']--;
            }
            if(Arrays.equals(s1Count,s2Count)) return true;
        }
        return false;
    }
}
