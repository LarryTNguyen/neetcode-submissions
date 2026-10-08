/**
Initial thoughts: this would be a really good problem is coins was already sorted from lowest to highest

cases
[1,5,10] and 12 --> 3 [2,0,1] quant of coins used

[2] and 3 --> -1 since you cant get only 3 dollars in 2 dollar coins

[1] and 0 --> 0

[1,3,4] and 6 --> 2 since you get 6 from two 3's 

0,1,2,3,4,5,6

0,1,2,1
think about how many coins will it take to get to the amount: 
have a loop from 0 to amount and have a loop for each coin
dp[0] = 0 
for 0 to amount
    for 0 to coin.length-1
        coinAmt <= curr amount:
            dp[curr] = min(dp[curr], 1+dp[x-coin])
*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[]dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for(int i = 1; i<=amount; i++){
            for(int coin: coins){
                if(i < coin) continue;
                dp[i] = Math.min(dp[i], 1+dp[i-coin]);
            }
        }
        if(dp[dp.length-1] == amount+1) return -1;
        return dp[dp.length-1];
    }
}
