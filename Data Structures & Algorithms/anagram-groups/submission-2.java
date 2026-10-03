class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap,List<String>> groups = new HashMap<>();
        ArrayList<List<String>> result = new ArrayList<>();
        for(String str : strs){
            char[] arr = str.toCharArray();
            HashMap<Character, Integer> freq = new HashMap<>();
            for(int i = 0; i < str.length(); i++){
                freq.put(arr[i],freq.getOrDefault(arr[i],0)+1);
            }
            if(!groups.containsKey(freq)){
                groups.put(freq, new ArrayList<String>());
            }
            groups.get(freq).add(str);
        }
        for(HashMap curr: groups.keySet()){
            result.add(groups.get(curr));
        }
        return result;
    }
}
