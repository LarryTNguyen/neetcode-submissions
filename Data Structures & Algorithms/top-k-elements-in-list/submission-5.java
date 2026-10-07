class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int num: nums){
            count.put(num, count.getOrDefault(num,0)+1);
        }
        List<Integer>[] freqCount = new List[nums.length+1];
        for(int key:count.keySet()){
            int freq = count.get(key);
            if(freqCount[freq] == null) freqCount[freq] = new ArrayList<>();
            freqCount[freq].add(key);
        }
        int index = 0;
        int[] answer = new int[k];
        for(int i = freqCount.length-1; i>=0; i--){
            if(index < k){
                List<Integer> selected = freqCount[i];
                if(selected!=null){
                    for(int j = 0; j < selected.size(); j++){
                        answer[index] = selected.get(j);
                        index++;
                    }
                }
            }
        }
        return answer;
    }
}
