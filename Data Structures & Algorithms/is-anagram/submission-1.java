class Solution {
    public boolean isAnagram(String s, String t) {

        int sl = s.length();
        int tl = t.length();

        if (sl != tl) {
            return false;
        }

        int[] c = new int[26];
        for (int i=0; i<s.length(); i++){
            c[s.charAt(i) - 'a']++;
            c[t.charAt(i) - 'a']--;
        }

        for (int n : c){
            if (n != 0){
                return false;
            }
        }

        return true;
    }
}
