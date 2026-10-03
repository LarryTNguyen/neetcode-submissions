class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqCount = new HashMap<>();
        int[] answer = new int[k];
        for(int num:nums){
            freqCount.put(num,freqCount.getOrDefault(num,0)+1);
        }
        List<Integer>[] buckets = new List[nums.length+1];
        for(int key:freqCount.keySet()){
            int freq = freqCount.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        int index = 0;
        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    answer[index++] = num;
                    if (index == k) break;
                }
            }
        }
        return answer;
    }
}
