public interface Tradeable {
    String getSymbol();

    double getCurrentPriceValue();

    boolean isAvailableForTrading();

    default String getTradingInfo() {
        // TODO
        throw new UnsupportedOperationException("TODO");
    }
}
