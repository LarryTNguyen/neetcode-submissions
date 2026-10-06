class Solution {
    public int maxProfit(int[] prices) {
        int bestBuy = prices[0];
        int bestProfit = 0;
        for(int price:prices){
            bestProfit = Math.max(bestProfit, price - bestBuy);
            bestBuy = Math.min(bestBuy, price);
        }
        return bestProfit;
    }
}


/**
bp = 6
bb = 1
[10,3,5,2,7,1]


*/