class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap,List<String>> anagramGroup = new HashMap<>();
        ArrayList<List<String>> returnable = new ArrayList<>();
        for(int i = 0; i < strs.length; i++){
            HashMap<Character, Integer> charCount = new HashMap<>();
            // System.out.println("Going through the word: " + strs[i]);
            for(int j = 0; j < strs[i].length(); j++){
                charCount.put(strs[i].charAt(j), charCount.getOrDefault(strs[i].charAt(j),0)+1);
            }
            // System.out.println("Done going through the word: " + strs[i]);
            if(anagramGroup.containsKey(charCount)){
                // System.out.println(strs[i]+ " was found in the anagramGroup.");
                anagramGroup.get(charCount).add(strs[i]);
            }
            else{
                // System.out.println(strs[i] + " added into anagramGroup.");
                ArrayList<String> value = new ArrayList<>();
                value.add(strs[i]);
                anagramGroup.put(charCount, value);
            }
        }
        // System.out.println("Going through all hashmaps in anagramgroup");
        for(HashMap<Character, Integer> c : anagramGroup.keySet()){
            returnable.add(anagramGroup.get(c));
            // System.out.println(anagramGroup.get(c));
        }
        return returnable;
    }
}
