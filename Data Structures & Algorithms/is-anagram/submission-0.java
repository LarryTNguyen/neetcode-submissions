class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sCount = new HashMap<>();
        HashMap<Character, Integer> tCount = new HashMap<>();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        for(char c:sArr){
            sCount.put(c, sCount.getOrDefault(c,0) +1);
        }
        for(char c:tArr){
            tCount.put(c, tCount.getOrDefault(c,0) +1);
        }

        return sCount.equals(tCount);
    }
}
