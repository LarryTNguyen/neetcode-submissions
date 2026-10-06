class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer,Integer> freqCount = new HashMap<>();
       for(int num: nums){
            freqCount.put(num, freqCount.getOrDefault(num, 0)+1);
       }
       List<Integer>[] freqArray = new List[nums.length+1];
       for(int num:freqCount.keySet()){
            if(freqArray[freqCount.get(num)] == null){
                freqArray[freqCount.get(num)] = new ArrayList<Integer>();
            }
            freqArray[freqCount.get(num)].add(num);
       }
       int[] answer = new int[k];
       int index = 0;
       for(int i = freqArray.length-1; i >=0 && index<k; i--){
            if(freqArray[i] != null){
                for(int val:freqArray[i]){
                    answer[index] = val;
                    index++;
                    if (index == k) break;
                }
            }
       }
       return answer;
    }
}
