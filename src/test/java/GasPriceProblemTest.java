import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GasPriceProblemTest {

    @ParameterizedTest
    @MethodSource("getParams")
    public void test(int buyDay, int sellDay, int[] prices) {
        GasPriceProblem.BuyAndSellDays buyAndSellDays = GasPriceProblem.getBuyAndSellDays(prices);
        assertEquals(buyDay, buyAndSellDays.buyDay(), "buy day");
        assertEquals(sellDay, buyAndSellDays.sellDay(), "sell day");
    }

    private static Stream<Arguments> getParams() {
        return Stream.of(
                Arguments.of(1, 3, new int[] {10, 20, 30, 20}),
                Arguments.of(0, 0, new int[] {30, 20, 10}),
                Arguments.of(1, 4, new int[] {20, 40, 30, 50, 10}),
                Arguments.of(3, 4, new int[] {30, 50, 10, 40})
        );
    }

}
