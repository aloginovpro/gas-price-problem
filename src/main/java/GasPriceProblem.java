public class GasPriceProblem {

    public static BuyAndSellDays getBuyAndSellDays(int[] prices, int moneyValue) {
        int globalMinIndex = 0;
        int maxDeltaBuyIndex = 0;
        int maxDeltaSellIndex = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[globalMinIndex]) {
                globalMinIndex = i;
            }

            if (getMoneyDelta(prices, moneyValue, globalMinIndex, i)
                    > getMoneyDelta(prices, moneyValue, maxDeltaBuyIndex, maxDeltaSellIndex)) {
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

    private static int getMoneyDelta(int[] prices, int moneyValue, int buyIndex, int sellIndex) {
        int volume = moneyValue / prices[buyIndex];
        int priceDelta = prices[sellIndex] - prices[buyIndex];
        return volume * priceDelta;
    }

    public record BuyAndSellDays(int buyDay, int sellDay) {}

}