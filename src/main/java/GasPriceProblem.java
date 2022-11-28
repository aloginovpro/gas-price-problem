public class GasPriceProblem {

    public static BuyAndSellDays getBuyAndSellDays(int[] prices) {
        int globalMinIndex = 0;
        int maxDeltaBuyIndex = 0;
        int maxDeltaSellIndex = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[globalMinIndex]) {
                globalMinIndex = i;
            }

            if (prices[i] - prices[globalMinIndex] > prices[maxDeltaSellIndex] - prices[maxDeltaBuyIndex]) {
                maxDeltaBuyIndex = globalMinIndex;
                maxDeltaSellIndex = i;
            }
        }

        if (maxDeltaSellIndex == 0) {
            return new BuyAndSellDays(0, 0);
        } else {
            return new BuyAndSellDays(maxDeltaBuyIndex + 1, maxDeltaSellIndex + 1);
        }
    }

    public record BuyAndSellDays(int buyDay, int sellDay) {}

}