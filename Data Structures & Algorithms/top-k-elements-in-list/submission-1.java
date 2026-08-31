class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> count = new HashMap<>();
        int[] answer = new int[k]; 
        for(int num:nums){
            count.put(num,count.getOrDefault(num,0)+1);
        }
        ArrayList<Integer>[] frequencies = new ArrayList[nums.length+1];
        for(int i = 0; i < frequencies.length; i++){
            ArrayList<Integer> indexFrequency = new ArrayList<>();
            frequencies[i] = indexFrequency;
        }
        for(int key:count.keySet()){
            frequencies[count.get(key)].add(key);
        }
        for(int i = frequencies.length-1; i > 0; i--){
            for(int j = 0; j < frequencies[i].size(); j++){
                if (k == 0) break;
                answer[--k] = frequencies[i].get(j);
            }
        }
        return answer;
    }
}
