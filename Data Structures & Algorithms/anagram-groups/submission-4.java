class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> storage = new HashMap<>();
        List<List<String>> answer = new ArrayList<>();
        for(String s: strs){
            HashMap<Character,Integer> count = new HashMap<>();
            for(char c: s.toCharArray()){
                count.put(c, count.getOrDefault(c, 0) +1);
            }
            storage.putIfAbsent(count, new ArrayList<String>());
            storage.get(count).add(s);
        }
        for(HashMap<Character,Integer> ana :storage.keySet()){
            answer.add(storage.get(ana));
        }
        return answer;    
    }  
}
