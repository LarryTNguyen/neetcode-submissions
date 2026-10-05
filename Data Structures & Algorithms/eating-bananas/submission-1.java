class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int upperBound = 0;
        for(int num : piles){
            if(num>upperBound){
                upperBound = num;
            }
        }
        int minRate = upperBound;
        int left = 1;
        int right = upperBound;
        while(left<=right){
            int median = (right+left)/2;
            int currHours = 0;
            for(int bananas:piles){
                currHours += (int)Math.ceil((double)bananas/median);
            }
            if(currHours > h){
                left = median+1;
            }
            else{
                if(minRate > median) minRate = median;
                right = median-1;
            }
        }
        return minRate;
    }
}
