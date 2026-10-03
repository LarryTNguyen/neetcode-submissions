class Solution {

    public String encode(List<String> strs) {
        String encoded = "";
        for(String str:strs){
            encoded += str.length() + "#" + str;
        }
        return encoded;
    }

    public List<String> decode(String str) {
        List<String> answer = new ArrayList<>();
        for(int i = 0; i<str.length(); i++){
            int k = i;
            while(str.charAt(k)!='#') k++;
            int length = Integer.parseInt(str.substring(i,k));
            answer.add(str.substring(k+1,k+length+1));
            i = k+length;
        }
        return answer;
    }
}
