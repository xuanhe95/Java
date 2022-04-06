class Solution {
    public int maxProfit(int[] prices) {
        int best = 0;
        int[] difference = new int[prices.length];
        difference[0] = 0;
        for (int i = 1; i < prices.length; i++ ){
            difference[i] = prices[i] - prices[i - 1];
            if ( difference[i] + difference[i - 1] > difference[i] ){
                difference[i] = difference[i] + difference[i - 1];
            }
            if (difference[i] > best){
                best = difference[i];
            }
        }
        return best;
    }
}