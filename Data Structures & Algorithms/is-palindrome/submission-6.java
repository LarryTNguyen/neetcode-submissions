class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        s = s.toLowerCase();
        char[] sArr = s.toCharArray();
        while(start<end){
            while(start<end && !isAlphaNum(sArr[start])) start++;
            while(start<end && !isAlphaNum(sArr[end])) end--;
            System.out.println(sArr[start]);
            System.out.println(sArr[end]);
            if(sArr[start] != sArr[end]) return false;
            start++;
            end--;
        }
        return true;
    }

    public boolean isAlphaNum(Character c){
        if(c >= 'A' && c<='Z'|| c >= 'a' && c<='z' || c >= '0' && c<= '9') return true;
        return false;
    }
}
