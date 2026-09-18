class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for (String s:strs){
            result+= s.length() + "#"+ s; 
        }
        System.out.println(result);
        return result;
    }

    public List<String> decode(String str) {
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            String strWL = "";
            System.out.println(i);
            for(int k = i; !(str.charAt(k) == '#'); k++){
                strWL += str.charAt(k);
            }
            int wordLength = Integer.parseInt(strWL);
            System.out.println(wordLength);
            String temp = str.substring(i+strWL.length()+1, i+strWL.length()+wordLength+1);
            result.add(temp);
            i+=strWL.length()+wordLength;
        }
        return result;
    }
}
