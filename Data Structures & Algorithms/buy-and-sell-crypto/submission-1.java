class Solution {
    public int maxProfit(int[] prices) {
        int bestBuy = -prices[0];
        int bestSell = prices[0];
        int bigProfit = bestBuy + bestSell;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > bestSell){
                bestSell = prices[i];
                if(bestBuy+bestSell>bigProfit){
                    bigProfit = bestBuy + bestSell;
                }
                
            }
            if(bestBuy < -prices[i]){
                bestBuy = -prices[i];
                bestSell = prices[i];
            }
        }
        return bigProfit;
    }
}
